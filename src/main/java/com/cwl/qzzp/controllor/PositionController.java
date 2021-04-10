package com.cwl.qzzp.controllor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/3/28
 * @description:职位控制器
 */
@Slf4j
@Controller
public class PositionController {

    @GetMapping("/positionList")
    public String getPositionData() {

        return "positionlist/positionList";
    }

    @GetMapping("/positionInfo")
    public String getPositionInfoData() {

        return "positionlist/positionInfo";
    }
}
