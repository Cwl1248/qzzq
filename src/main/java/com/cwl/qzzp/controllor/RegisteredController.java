package com.cwl.qzzp.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/19
 * @description：注册控制器
 */
@Controller
public class RegisteredController {

   @GetMapping("/registered")
    public String registered() {
        return "page/login-3";
    }

    @GetMapping("/toIndex")
    public String toIndex() {
        return "managePage/index";
    }
}
