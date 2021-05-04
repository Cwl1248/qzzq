package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.dto.EnterpriseinfoDTO;
import com.cwl.qzzp.service.EnterpriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/3/29
 * @description：招聘公司
 */
@Slf4j
@Controller
@RequestMapping("/company")
public class CompanyListController {
    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/companyList")
    public String getCompanyListData() {

        return "companyList/companyList";
    }

    @GetMapping("/companyInfo")
    public String getCompanyInfoData() {

        return "companyList/companyInfo";
    }

    @PostMapping("/increase")
    @ResponseBody
    public ResultData increaseData(@RequestBody EnterpriseinfoDTO company) {
        return enterpriseService.increaseData(company);
    }


    @GetMapping("/selectByPk")
    @ResponseBody
    public ResultData selectByPk(String eid){
        return enterpriseService.selectByPk(eid);
    }


    @PostMapping("/updata")
    @ResponseBody
    public ResultData updata(@RequestBody EnterpriseinfoDTO company) {
        return enterpriseService.updata(company);
    }
}
