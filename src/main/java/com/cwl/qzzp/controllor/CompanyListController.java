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

    /**
     * @param modelMap
     * @param pageNum  页号
     * @param pageSize 每页数据
     * @return 分页显示公司信息
     */
    @GetMapping("/companyList")
    public String getCompanyListData(ModelMap modelMap, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                     @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                     String title, String place, String category, String numberofworkers, String financingstage) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 12;
        }
        Page<EnterpriseinfoDTO> listData = (Page<EnterpriseinfoDTO>) enterpriseService.getCompanyListData(pageNum, pageSize,
                title, place, category, numberofworkers, financingstage);
        modelMap.addAttribute("list", listData);
        return "companyList/companyList";
    }

    /**
     * @param modelMap
     * @param eId      公司的主键
     * @return 公司的详细信息
     */
    @GetMapping("/companyInfo")
    public String getCompanyInfoData(ModelMap modelMap, String eId) {
        EnterpriseinfoDTO companyInfoData = enterpriseService.getCompanyInfoData(eId);
        modelMap.addAttribute("companyInfoData", companyInfoData);
        return "companyList/companyInfo";
    }

    /**
     * 后台添加公司信息
     *
     * @param company
     * @return
     */
    @PostMapping("/increase")
    @ResponseBody
    public ResultData increaseData(@RequestBody EnterpriseinfoDTO company) {
        return enterpriseService.increaseData(company);
    }

    /**
     * 后台查询公司信息
     *
     * @param company
     * @return
     */
    @GetMapping("/selectByPk")
    @ResponseBody
    public ResultData selectByPk(String eid) {
        return enterpriseService.selectByPk(eid);
    }

    /**
     * 后台更新公司信息
     *
     * @param company
     * @return
     */
    @PostMapping("/updata")
    @ResponseBody
    public ResultData updata(@RequestBody EnterpriseinfoDTO company) {
        return enterpriseService.updata(company);
    }
}
