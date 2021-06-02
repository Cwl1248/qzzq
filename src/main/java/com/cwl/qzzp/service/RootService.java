package com.cwl.qzzp.service;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.common.annotation.Page;
import com.cwl.qzzp.dao.EnterpriseinfoDao;
import com.cwl.qzzp.dao.RootMapper;
import com.cwl.qzzp.dto.EnterpriseinfoDTO;
import com.cwl.qzzp.dto.Root;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/6/1
 * @description：TODO
 */
@Service("rootService")
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {Exception.class})
public class RootService {

    @Autowired
    RootMapper rootMapper;

    @Autowired
    EnterpriseinfoDao enterpriseinfoMapper;

    public ResultData login(Root root) {

        Root root1 = rootMapper.selectByPrimaryKey(root);
        if (ObjectUtils.isNotEmpty(root1)) {
            return ResultData.ok();
        } else {
            return ResultData.failed(RetCode.FAIL);
        }

    }

    @Page
    public ResultData getAllCompany() {
        List<EnterpriseinfoDTO> enterpriseinfoDTOS = enterpriseinfoMapper.selectALL();

        if (enterpriseinfoDTOS.size() > 0) {
            return ResultData.ok(enterpriseinfoDTOS);
        } else {
            return ResultData.failed(RetCode.FAIL);
        }
    }
}
