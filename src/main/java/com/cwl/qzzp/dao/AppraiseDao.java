package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.AppraiseDTO;

public interface AppraiseDao {
    int deleteByPrimaryKey(String itemid);

    int insert(AppraiseDTO record);

    int insertSelective(AppraiseDTO record);

    AppraiseDTO selectByPrimaryKey(String itemid);

    int updateByPrimaryKeySelective(AppraiseDTO record);

    int updateByPrimaryKey(AppraiseDTO record);
}