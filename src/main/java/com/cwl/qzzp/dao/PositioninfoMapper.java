package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.PositioninfoDTO;

public interface PositioninfoMapper {
    int deleteByPrimaryKey(String pid);

    int insert(PositioninfoDTO record);

    int insertSelective(PositioninfoDTO record);

    PositioninfoDTO selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(PositioninfoDTO record);

    int updateByPrimaryKey(PositioninfoDTO record);
}