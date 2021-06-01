package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.dto.RecruiterinforDTO;
import com.cwl.qzzp.service.RecruiterinforService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/30
 * @description：招聘者
 */
@Slf4j
@RestController
@RequestMapping("/RecruiterInfor")
public class RecruiterInforController {

    @Autowired
    RecruiterinforService recruiterinforService;

    @PostMapping("/login")
    public ResultData login(@RequestBody RecruiterinforDTO recruiterinforDTO) {

        return recruiterinforService.login(recruiterinforDTO);
    }

    @PostMapping("/registered")
    public ResultData registered(@RequestBody RecruiterinforDTO recruiterinforDTO) {

        return recruiterinforService.registered(recruiterinforDTO);
    }
    @GetMapping("/getLoginUser")
    public ResultData getLoginUser(String id){
          if(StringUtils.isNotEmpty(id)){
              RecruiterinforDTO recruiterinforDTO = new RecruiterinforDTO();
              recruiterinforDTO.setItemid(id);
              RecruiterinforDTO loginUser = recruiterinforService.getLoginUser(recruiterinforDTO);
              if (ObjectUtils.isNotEmpty(loginUser)){
                  return ResultData.ok(loginUser);
              }else {
                  return ResultData.failed(RetCode.FAIL);
              }
          }else {
              return ResultData.failed(RetCode.FAIL);
          }

    }

    @PostMapping("/updateLoginUser")
    public ResultData updateLoginUser(@RequestBody RecruiterinforDTO recruiterinforDTO){
        return recruiterinforService.updateLoginUser(recruiterinforDTO);
    }
}
