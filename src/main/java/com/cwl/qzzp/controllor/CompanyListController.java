package com.cwl.qzzp.controllor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/3/29
 * @description：招聘公司
 */
@Slf4j
@Controller
public class CompanyListController {

    @GetMapping("/companyList")
    public String getCompanyListData() {

        return "companyList/companyList";
    }

    @GetMapping("/companyInfo")
    public String getCompanyInfoData() {

        return "companyList/companyInfo";
    }
}
