package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.RecruiterinforDTO;

public interface RecruiterinforMapper {
    int deleteByPrimaryKey(String itemid);

    int insert(RecruiterinforDTO record);

    int insertSelective(RecruiterinforDTO record);

    RecruiterinforDTO selectByPrimaryKey(String itemid);

    int updateByPrimaryKeySelective(RecruiterinforDTO record);

    int updateByPrimaryKey(RecruiterinforDTO record);
}