package com.cwl.qzzp.service;

import com.cwl.qzzp.dao.ManagementteamDao;
import com.cwl.qzzp.dto.ManagementteamDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/31
 * @description：TODO
 */
@Service("teamService")
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {Exception.class})
public class TeamService {

    @Autowired
    ManagementteamDao managementteamDao;

    public int insertTeamInfo(ManagementteamDTO managementteamDTO) {
        return managementteamDao.insertSelective(managementteamDTO);
    }
}
