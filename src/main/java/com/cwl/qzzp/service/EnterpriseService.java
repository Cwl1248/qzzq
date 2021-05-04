package com.cwl.qzzp.service;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.dao.EnterpriseinfoDao;
import com.cwl.qzzp.dao.RecruiterinforDao;
import com.cwl.qzzp.dto.EnterpriseinfoDTO;
import com.cwl.qzzp.dto.RecruiterinforDTO;
import com.cwl.qzzp.util.GetUUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/2
 * @description：TODO
 */
@Service("enterpriseService")
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {Exception.class})
public class EnterpriseService {
    @Autowired
    EnterpriseinfoDao enterpriseinfoMapper;

    @Autowired
    RecruiterinforDao recruiterinforMapper;

    public ResultData increaseData(EnterpriseinfoDTO company) {
        log.info("company:{}", company);
        String eid = GetUUIDUtil.getUUID();
        try {
            if (company != null) {
                company.setEid(eid);
            }
            /*在添加公司信息的时候将招聘者与公司绑定起来，即把公司的主键绑定到招聘者的dataid属性*/
            int i = enterpriseinfoMapper.insertSelective(company);
            RecruiterinforDTO recruiterinforDTO = new RecruiterinforDTO();
            assert company != null;
            recruiterinforDTO.setItemid(company.getItemid());
            recruiterinforDTO.setDataid(eid);
            recruiterinforDTO.setCompanyname(company.getEname());
            recruiterinforMapper.updateByPrimaryKeySelective(recruiterinforDTO);
            if (i > 0) {
                return ResultData.ok(eid);
            }
        } catch (Exception e) {
            log.error("添加公司信息失败{}", e.getMessage(), e);
            return ResultData.failed(RetCode.FAIL, "添加公司信息失败");
        }

        return ResultData.ok(eid);
    }

    public ResultData selectByPk(String eid) {
        log.debug(eid);
        EnterpriseinfoDTO enterpriseinfoDTO = new EnterpriseinfoDTO();
        if (StringUtils.isNotBlank(eid)) {
            enterpriseinfoDTO = enterpriseinfoMapper.selectByPrimaryKey(eid);
        } else {
            return ResultData.failed(RetCode.FAIL, "查询公司信息失败");
        }
        if (enterpriseinfoDTO != null) {
            return ResultData.ok(enterpriseinfoDTO);
        } else {
            return ResultData.failed(RetCode.FAIL, "查询公司信息失败");
        }
    }

    public ResultData updata(EnterpriseinfoDTO company) {
        log.debug("company",company);
        if (ObjectUtils.isNotEmpty(company)) {
            int i = enterpriseinfoMapper.updateByPrimaryKeySelective(company);
            if (i != 0) {
                return ResultData.ok();
            } else {
                return ResultData.failed(RetCode.FAIL, "更新公司信息失败");
            }
        } else {
            return ResultData.failed(RetCode.FAIL, "更新公司信息失败");
        }
    }
}
