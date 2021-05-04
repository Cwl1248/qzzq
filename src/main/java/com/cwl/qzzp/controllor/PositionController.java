package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.PagingDTO;
import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.dto.PositioninfoDTO;
import com.cwl.qzzp.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/3/28
 * @description:职位控制器
 */
@Slf4j
@Controller
@RequestMapping("position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/positionList")
    public String getPositionData() {

        return "positionlist/positionList";
    }

    @GetMapping("/positionInfo")
    public String getPositionInfoData() {

        return "positionlist/positionInfo";
    }

    @PostMapping("/posting")
    @ResponseBody
    public ResultData postingPositionInfoData(@RequestBody PositioninfoDTO position) {
        return positionService.postingPositionInfoData(position);
    }


    @GetMapping("/getAllPosition")
    @ResponseBody
    public ResultData<PagingDTO<PositioninfoDTO>> getAllPosition() {
        return positionService.getAllPosition();
    }


    @PostMapping("/upData")
    @ResponseBody
    public ResultData upDataPositionInfoData(@RequestBody PositioninfoDTO position) {
        return positionService. upDataPositionInfoData(position);
    }

}
