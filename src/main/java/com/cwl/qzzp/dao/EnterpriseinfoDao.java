package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.EnterpriseinfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseinfoDao {
    int deleteByPrimaryKey(String eid);

    int insert(EnterpriseinfoDTO record);

    int insertSelective(EnterpriseinfoDTO record);

    EnterpriseinfoDTO selectByPrimaryKey(String eid);

    int updateByPrimaryKeySelective(EnterpriseinfoDTO record);

    int updateByPrimaryKey(EnterpriseinfoDTO record);

    List<EnterpriseinfoDTO> getCompanyListData(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    List<EnterpriseinfoDTO> selectALL();
}