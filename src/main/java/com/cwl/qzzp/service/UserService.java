package com.cwl.qzzp.service;

import com.cwl.qzzp.dao.UserinfoDao;
import com.cwl.qzzp.dto.UserinfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/24
 * @description：TODO
 */
@Service("userService")
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {Exception.class})
public class UserService {

    @Autowired
    UserinfoDao UserinfoMapper;

    public UserinfoDTO login(UserinfoDTO user) {

        return UserinfoMapper.selectByPK(user);
    }

    public Integer registered(UserinfoDTO user) {

        return  UserinfoMapper.insertSelective(user);
    }

    public Integer addinfo(UserinfoDTO user) {
        return  UserinfoMapper.updateByPrimaryKeySelective(user);
    }
}
