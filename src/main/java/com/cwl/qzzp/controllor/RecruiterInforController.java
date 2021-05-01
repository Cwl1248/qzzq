package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.service.RecruiterinforService;
import lombok.extern.slf4j.Slf4j;
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
    public ResultData login(@RequestBody String username, String password) {

        return recruiterinforService.login(username,password);
    }

    @PostMapping("/registered")
    public ResultData registered(@RequestBody String username, String password) {

        return recruiterinforService.registered(username,password);
    }
}
