package com.cwl.qzzp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author 李显星
 * @date 2021/5/14 21:43
 **/
public class JWTUtil {

    //自定义一个密钥
    private static final String SIGN = "S!#$DRerGD&*E$#DGhhs@@fh#fsj";

    /**
     * 生成 Token
     * @param map
     * @return
     */
    public static String getToken(Map<String,String> map){

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, 30);

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        //payload(有效载荷)
        map.forEach((k,v) -> {
            builder.withClaim(k,v);
        });

        //生成token
        String token = builder.withExpiresAt(instance.getTime()) //指定token过期时间
                .sign(Algorithm.HMAC256(SIGN));//生成token的算法和密钥

        return token;
    }


    /**
     * 验证token合法性（验证不通过会返回异常）
     * @param token
     */
    public static void verifyToken(String token){
        //创建验证对象
        JWTVerifier build = JWT.require(Algorithm.HMAC256(SIGN)).build();
        //验证
        build.verify(token);
    }


    /**
     * 获取token信息
     * @param token
     * @return
     */
    public static DecodedJWT getTokenInfo(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return verify;
    }
}
