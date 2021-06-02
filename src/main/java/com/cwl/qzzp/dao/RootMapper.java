package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.Root;
import org.springframework.stereotype.Repository;

@Repository
public interface RootMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Root record);

    int insertSelective(Root record);

    Root selectByPrimaryKey(Root Root);

    int updateByPrimaryKeySelective(Root record);

    int updateByPrimaryKey(Root record);
}