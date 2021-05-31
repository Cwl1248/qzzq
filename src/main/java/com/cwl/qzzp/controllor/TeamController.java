package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.dto.ManagementteamDTO;
import com.cwl.qzzp.service.TeamService;
import com.cwl.qzzp.util.GetUUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/31
 * @description：管理团队
 */

@Controller
@Slf4j
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping("/insert/teamInfo")
    @ResponseBody
    private ResultData insertTeamInfo(@RequestBody ManagementteamDTO managementteamDTO) {

        log.info("", managementteamDTO);

        try {
            if (StringUtils.isNotEmpty(managementteamDTO.getDataid())) {

                managementteamDTO.setMids(GetUUIDUtil.getUUID());
                int i = teamService.insertTeamInfo(managementteamDTO);
                if (i != 0) {
                    return ResultData.ok();
                }

            } else {
                return ResultData.failed(RetCode.FAIL.code, "添加失败");
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.FAIL.code, "添加失败", e);
        }
        return ResultData.failed(RetCode.FAIL.code, "添加失败");
    }

}
