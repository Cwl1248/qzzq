package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.PagingDTO;
import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.dto.EnterpriseinfoDTO;
import com.cwl.qzzp.dto.Root;
import com.cwl.qzzp.service.RootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/6/1
 * @description：TODO
 */
@Slf4j
@Controller
@RequestMapping("/root")
public class RootUserController {

    @Autowired
    RootService rootService;

    /**
     * 管理员
     *
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome() {
        return "root/rootLogin";
    }

    @RequestMapping("/toIndex2")
    public String toIndex2() {
        return "managePage/rootindex";
    }


    @RequestMapping("/approve")
    public String approve() {
        return "managePage/approve";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultData login(@RequestBody Root root) {

        return rootService.login(root);
    }

    @GetMapping("/getAllCompany")
    @ResponseBody
    public ResultData<PagingDTO<EnterpriseinfoDTO>>  getAllCompany() {

        return rootService.getAllCompany();
    }
}
