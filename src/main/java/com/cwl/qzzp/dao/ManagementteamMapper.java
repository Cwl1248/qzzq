package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.ManagementTeamDTO;

public interface ManagementteamMapper {
    int deleteByPrimaryKey(String mids);

    int insert(ManagementTeamDTO record);

    int insertSelective(ManagementTeamDTO record);

    ManagementTeamDTO selectByPrimaryKey(String mids);

    int updateByPrimaryKeySelective(ManagementTeamDTO record);

    int updateByPrimaryKey(ManagementTeamDTO record);
}