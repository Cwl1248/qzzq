package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.UserinfoDTO;

public interface UserinfoDao {
    int deleteByPrimaryKey(String userid);

    int insert(UserinfoDTO record);

    int insertSelective(UserinfoDTO record);

    UserinfoDTO selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(UserinfoDTO record);

    int updateByPrimaryKey(UserinfoDTO record);
}