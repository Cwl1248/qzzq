package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.RecruiterinforDTO;

import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterinforDao {

    int deleteByPrimaryKey(String itemid);

    int insert(RecruiterinforDTO record);

    int insertSelective(RecruiterinforDTO record);

    RecruiterinforDTO selectByPrimaryKey(RecruiterinforDTO record);

    int updateByPrimaryKeySelective(RecruiterinforDTO record);

    int updateByPrimaryKey(RecruiterinforDTO record);

    RecruiterinforDTO selectByPK(RecruiterinforDTO record);
}