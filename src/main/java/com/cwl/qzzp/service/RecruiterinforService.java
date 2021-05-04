package com.cwl.qzzp.service;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.dao.RecruiterinforDao;
import com.cwl.qzzp.dto.RecruiterinforDTO;
import com.cwl.qzzp.util.GetUUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/30
 * @description：招聘者
 */
@Service("recruiterinforService")
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {Exception.class})
public class RecruiterinforService {
    @Autowired
    RecruiterinforDao recruiterinforMapper;

    public ResultData login(RecruiterinforDTO recruiterinforDTO) {
        if (ObjectUtils.isNotEmpty(recruiterinforDTO)) {
            RecruiterinforDTO recruiterinfor = recruiterinforMapper.selectByPrimaryKey(recruiterinforDTO);
            if (ObjectUtils.isNotEmpty(recruiterinfor)) {
                return ResultData.ok(recruiterinfor.getItemid());
            } else {
                return ResultData.failed(RetCode.LOGINFAIL, "登录失败");
            }

        } else {
            return ResultData.failed(RetCode.LOGINFAIL, "登录失败");
        }
    }


    public ResultData registered(RecruiterinforDTO recruiterinforDTO) {
        String itemid = GetUUIDUtil.getUUID();
        if (ObjectUtils.isNotEmpty(recruiterinforDTO)) {
            recruiterinforDTO.setItemid(itemid);
            int insert = recruiterinforMapper.insertSelective(recruiterinforDTO);
            if (insert != 0) {
                return ResultData.ok(itemid);
            } else {
                return ResultData.failed(RetCode.REGISTRATIONFAILED.code, "注册失败");
            }
        } else {
            return ResultData.failed(RetCode.REGISTRATIONFAILED.code, "注册失败");
        }

    }
}
