package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.EnterpriseinfoDTO;

public interface EnterpriseinfoDao {
    int deleteByPrimaryKey(String eid);

    int insert(EnterpriseinfoDTO record);

    int insertSelective(EnterpriseinfoDTO record);

    EnterpriseinfoDTO selectByPrimaryKey(String eid);

    int updateByPrimaryKeySelective(EnterpriseinfoDTO record);

    int updateByPrimaryKey(EnterpriseinfoDTO record);
}