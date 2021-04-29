package com.cwl.qzzp.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/26
 * @description：后台管理中继
 */
@Controller
@RequestMapping("manage")
public class ManagerController {

    /**
     * 首页
     * @return
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "page/welcome-1";
    }

    /**
     * 职位发布
     * @return
     */
    @GetMapping("/jobPosting")
    public String jobPosting() {
        return "page/form";
    }

    /**
     * 职位表格管理
     * @return
     */
    @GetMapping("/jobTable")
    public String jobTable() {
        return "page/table";
    }


    /**
     * 更新职位数据
     * @return
     */
    @GetMapping("/upDataJobTable")
    public String upDataJobTable(String pid) {
        return "page/table/edit";
    }
}
