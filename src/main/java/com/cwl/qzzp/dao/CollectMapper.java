package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.CollectDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(CollectDto record);

    int insertSelective(CollectDto record);

    CollectDto selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(CollectDto record);

    int updateByPrimaryKey(CollectDto record);

    List<CollectDto> getCollectionPosition(@Param("pageNum")int pageNum, @Param("pageSize") int pageSize, String userid);
}