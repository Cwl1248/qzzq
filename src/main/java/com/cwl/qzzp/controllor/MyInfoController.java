package com.cwl.qzzp.controllor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/10
 * @description：个人信息
 */
@Slf4j
@Controller
@RequestMapping("/myInfo")
public class MyInfoController {


    @RequestMapping("/InfoDetail")
    public String getMyInfoData() {
        return "myInfo/myInfo";
    }

}
