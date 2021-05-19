package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.dto.EnterpriseinfoDTO;
import com.cwl.qzzp.service.EnterpriseService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String getCompanyListData(ModelMap modelMap, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 12;
        }
        Page<EnterpriseinfoDTO> listData = (Page<EnterpriseinfoDTO>) enterpriseService.getCompanyListData(pageNum, pageSize);
        modelMap.addAttribute("list", listData);
        return "companyList/companyList";
    }

    @GetMapping("/companyInfo")
    public String getCompanyInfoData(ModelMap modelMap, String eId) {
        EnterpriseinfoDTO companyInfoData = enterpriseService.getCompanyInfoData(eId);
        modelMap.addAttribute("companyInfoData",companyInfoData);
        return "companyList/companyInfo";
    }

    @PostMapping("/increase")
    @ResponseBody
    public ResultData increaseData(@RequestBody EnterpriseinfoDTO company) {
        return enterpriseService.increaseData(company);
    }


    @GetMapping("/selectByPk")
    @ResponseBody
    public ResultData selectByPk(String eid) {
        return enterpriseService.selectByPk(eid);
    }


    @PostMapping("/updata")
    @ResponseBody
    public ResultData updata(@RequestBody EnterpriseinfoDTO company) {
        return enterpriseService.updata(company);
    }
}
