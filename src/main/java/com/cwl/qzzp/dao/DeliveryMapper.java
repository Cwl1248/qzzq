package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.DeliveryDto;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(DeliveryDto record);

    int insertSelective(DeliveryDto record);

    DeliveryDto selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(DeliveryDto record);

    int updateByPrimaryKey(DeliveryDto record);
}