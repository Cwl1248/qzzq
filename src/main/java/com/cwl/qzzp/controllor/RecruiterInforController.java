package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.dto.RecruiterinforDTO;
import com.cwl.qzzp.service.RecruiterinforService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
