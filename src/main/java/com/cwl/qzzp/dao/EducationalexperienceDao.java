package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.EducationalexperienceDTO;

public interface EducationalexperienceDao {
    int deleteByPrimaryKey(String id);

    int insert(EducationalexperienceDTO record);

    int insertSelective(EducationalexperienceDTO record);

    EducationalexperienceDTO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EducationalexperienceDTO record);

    int updateByPrimaryKey(EducationalexperienceDTO record);
}