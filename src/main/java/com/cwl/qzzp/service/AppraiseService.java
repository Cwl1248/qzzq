package com.cwl.qzzp.service;

import com.cwl.qzzp.dao.AppraiseDao;
import com.cwl.qzzp.dto.AppraiseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/30
 * @description：评价
 */
@Service("appraiseService")
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {Exception.class})
public class AppraiseService {


    @Autowired
    AppraiseDao appraiseMapper;

    public int insertAppraise(AppraiseDTO appraiseDTO) {
        return appraiseMapper.insertSelective(appraiseDTO);
    }
}


