package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.WorkExperienceDTO;

public interface WorkExperienceDao {
    int deleteByPrimaryKey(String id);

    int insert(WorkExperienceDTO record);

    int insertSelective(WorkExperienceDTO record);

    WorkExperienceDTO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WorkExperienceDTO record);

    int updateByPrimaryKey(WorkExperienceDTO record);
}