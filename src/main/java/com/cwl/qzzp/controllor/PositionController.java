package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.PagingDTO;
import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.dto.AppraiseDTO;
import com.cwl.qzzp.dto.PositioninfoDTO;
import com.cwl.qzzp.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String getPositionInfoData(ModelMap modelMap, String pid) {
        PositioninfoDTO positioninfo = positionService.getPositionInfoData(pid);
        List<AppraiseDTO> appraiseDTO = positioninfo.getAppraiseDTO();
        double environment = 0;
        double ratingtheinterviewe = 0;
        double matchscore = 0;
        double multiplescore = 0;
        double e = 0, r = 0, m = 0, mu = 0;
        if (appraiseDTO.size() > 0) {
            for (AppraiseDTO dto : appraiseDTO) {
                if (dto.getEnvironment() > 0 && dto.getMatchscore() > 0 && dto.getRatingtheinterviewe() > 0 && dto.getMultiplescore() > 0) {
                    environment += dto.getEnvironment();
                    matchscore += dto.getMatchscore();
                    ratingtheinterviewe += dto.getRatingtheinterviewe();
                    multiplescore += dto.getMultiplescore();
                }
            }
            e = Math.ceil(environment / appraiseDTO.size());
            r = Math.ceil(ratingtheinterviewe / appraiseDTO.size());
            m = Math.ceil(matchscore / appraiseDTO.size());
            mu = Math.ceil(multiplescore / appraiseDTO.size());
        }
        modelMap.addAttribute("position", positioninfo);
        modelMap.addAttribute("e", e);
        modelMap.addAttribute("r", r);
        modelMap.addAttribute("m", m);
        modelMap.addAttribute("mu", mu);
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
        return positionService.upDataPositionInfoData(position);
    }

}
