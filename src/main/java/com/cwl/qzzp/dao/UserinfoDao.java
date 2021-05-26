package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.UserinfoDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserinfoDao {
    int deleteByPrimaryKey(String userid);

    int insert(UserinfoDTO record);

    int insertSelective(UserinfoDTO record);

    UserinfoDTO selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(UserinfoDTO record);

    int updateByPrimaryKey(UserinfoDTO record);

    UserinfoDTO selectByPK(UserinfoDTO user);
}