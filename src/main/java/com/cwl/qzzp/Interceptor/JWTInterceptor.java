package com.cwl.qzzp.Interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.cwl.qzzp.util.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author 李显星
 * @date 2021/5/14 21:40
 **/
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HashMap<String, String> map = new HashMap<>();
        //获取请求钟的token
        String token = request.getHeader("token");

        try {
            //验证token
            JWTUtil.verifyToken(token);
            return true;
        }catch (SignatureVerificationException e){
            map.put("msg","无效签名");
            e.printStackTrace();
        }catch (TokenExpiredException e){
            map.put("msg","token过期");
            e.printStackTrace();
        }catch (AlgorithmMismatchException e){
            map.put("msg","算法不一致");
            e.printStackTrace();
        }catch (Exception e){
            map.put("msg","token无效");
            e.printStackTrace();
        }

        map.put("status","false");
        //将map转换为json
        String json = new ObjectMapper().writeValueAsString(map);
        //设置json的格式
        response.setContentType("application/json;charset=UTF-8");
        //将json输到前端
        response.getWriter().println(json);

        return false;
    }
}
