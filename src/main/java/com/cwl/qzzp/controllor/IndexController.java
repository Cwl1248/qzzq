package com.cwl.qzzp.controllor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/3/14
 * @description：首页
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping("*/")
    public String getIndexData(){

                return "index/index";
    }
}
