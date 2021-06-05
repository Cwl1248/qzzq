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
     * 首页  已舍弃
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


    /**
     * 修改资料
     * @return
     */
    @GetMapping("/modifyInformation")
    public String modifyInformation() {
        return "page/user-setting";
    }

    /**
     * 修改密码
     * @return
     */
    @GetMapping("/changePassword")
    public String changePassword() {
        return "page/user-password";
    }

    /**
     * 添加公司信息
     * @return
     */
    @GetMapping("/addCompanyInformation")
    public String addCompanyInformation() {
        return "page/companyform";
    }


    /**
     * 修改公司信息
     * @return
     */
    @GetMapping("/upDataCompanyInformation")
    public String upDataCompanyInformation() {
        return "page/editCompanyform";
    }


    /**
     * 添加管理团队信息
     * @return
     */
    @GetMapping("/addManagementTeamInformation")
    public String addManagementTeamInformation() {
        return "page/tramFrom";
    }

    /**
     * 添加管理团队信息
     * @return
     */
    @GetMapping("/updateManagementTeamInformation")
    public String updateManagementTeamInformation() {
        return "page/tramFrom2";
    }

    @GetMapping("/resumeDelivery")
    public String resumeDelivery(){
        return "page/deliverytable";
    }



}
