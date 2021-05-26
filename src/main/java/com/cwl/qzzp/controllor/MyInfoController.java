package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.dto.UserinfoDTO;
import com.cwl.qzzp.service.UserService;
import com.cwl.qzzp.util.GetUUIDUtil;
import com.cwl.qzzp.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/10
 * @description：个人信息
 */
@Slf4j
@Controller
@RequestMapping("/myInfo")
public class MyInfoController {

    @Autowired
    UserService userService;

    @RequestMapping("/InfoDetail")
    public String getMyInfoData() {
        return "myInfo/myInfo";
    }

    @RequestMapping("/toSelect")
    public String toSelect() {
        return "myInfo/updateInfo";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultData login(@RequestBody UserinfoDTO user) {
        log.info("", user);
        Map<Object, Object> map = new HashMap<>();

        try {
            if (ObjectUtils.isNotEmpty(user)) {
                UserinfoDTO login = userService.login(user);
                if (ObjectUtils.isNotEmpty(user)) {
                    String token = JWTUtil.getToken(new HashMap<>());
                    map.put("token", token);
                    map.put("Userid", login.getUserid());
                    return ResultData.ok(map);
                } else {
                    return ResultData.failed(RetCode.LOGINFAIL);
                }
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.LOGINFAIL.code, "登录失败", e);
        }
        return ResultData.ok();
    }

    @PostMapping("/registered")
    @ResponseBody
    public ResultData registered(@RequestBody UserinfoDTO user) {
        log.info("", user);
        try {
            if (ObjectUtils.isNotEmpty(user)) {
                user.setUserid(GetUUIDUtil.getUUID());
                Integer i = userService.registered(user);
                if (ObjectUtils.isNotEmpty(i)) {
                    return ResultData.ok();
                } else {
                    return ResultData.failed(RetCode.LOGINFAIL);
                }
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.LOGINFAIL.code, "注册失败", e);
        }
        return ResultData.ok();
    }

    @PostMapping("/addinfo")
    @ResponseBody
    public ResultData addinfo(@RequestBody UserinfoDTO user) {
        log.info("", user);
        try {
            if (StringUtils.isNotEmpty(user.getUserid())) {
                Integer i = userService.addinfo(user);
                if (ObjectUtils.isNotEmpty(i)) {
                    return ResultData.ok();
                } else {
                    return ResultData.failed(RetCode.LOGINFAIL);
                }
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.LOGINFAIL.code, "添加失败", e);
        }
        return ResultData.ok();
    }


    @PostMapping("/updataInfo")
    @ResponseBody
    public ResultData updataInfo(@RequestBody UserinfoDTO user) {
        log.info("", user);
        try {
            if (StringUtils.isNotEmpty(user.getUserid())) {
                Integer i = userService.addinfo(user);
                if (ObjectUtils.isNotEmpty(i)) {
                    return ResultData.ok();
                } else {
                    return ResultData.failed(RetCode.FAIL);
                }
            } else {
                return ResultData.failed(RetCode.FAIL);
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.FAIL.code, "修改失败", e);
        }
    }

    @GetMapping("/selectInfo")
    @ResponseBody
    public ResultData selectInfo(String userid) {
        log.info("", userid);
        try {
            if (StringUtils.isNotEmpty(userid)) {
                UserinfoDTO userinfoDTO = userService.selectInfo(userid);
                if (ObjectUtils.isNotEmpty(userinfoDTO)) {
                    return ResultData.ok(userinfoDTO);
                } else {
                    return ResultData.failed(RetCode.FAIL);
                }
            } else {
                return ResultData.failed(RetCode.FAIL);
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.LOGINFAIL.code, "查询失败", e);
        }

    }
}
