package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.ManagementteamDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementteamDao {
    int deleteByPrimaryKey(String mids);

    int insert(ManagementteamDTO record);

    int insertSelective(ManagementteamDTO record);

    ManagementteamDTO selectByPrimaryKey(String mids);

    int updateByPrimaryKeySelective(ManagementteamDTO record);

    int updateByPrimaryKey(ManagementteamDTO record);
}