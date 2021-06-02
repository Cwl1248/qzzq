package com.cwl.qzzp.controllor;

import com.cwl.qzzp.dto.PositioninfoDTO;
import com.cwl.qzzp.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/3/14
 * @description：门户首页
 */
@Slf4j
@Controller
public class IndexController {
    @Autowired
    PositionService positionService;

    @GetMapping("/index")
    public String getIndexData(ModelMap modelMap,String title) {
        List<PositioninfoDTO> list = positionService.getIndexPosition(title);
        modelMap.addAttribute("positionInfoList",list);
        return "index/index";
    }
}
