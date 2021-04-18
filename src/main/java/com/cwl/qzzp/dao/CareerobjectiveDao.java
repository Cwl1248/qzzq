package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.CareerobjectiveDTO;

public interface CareerobjectiveDao {
    int deleteByPrimaryKey(String id);

    int insert(CareerobjectiveDTO record);

    int insertSelective(CareerobjectiveDTO record);

    CareerobjectiveDTO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CareerobjectiveDTO record);

    int updateByPrimaryKey(CareerobjectiveDTO record);
}