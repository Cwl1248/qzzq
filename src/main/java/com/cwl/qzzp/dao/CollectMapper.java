package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.CollectDto;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(CollectDto record);

    int insertSelective(CollectDto record);

    CollectDto selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(CollectDto record);

    int updateByPrimaryKey(CollectDto record);
}