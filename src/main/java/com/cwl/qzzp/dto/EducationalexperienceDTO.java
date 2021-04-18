package com.cwl.qzzp.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * educationalexperience
 * @author 
 */
@Data
public class EducationalexperienceDTO implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 数据源
     */
    private String dataid;

    /**
     * 学校名称
     */
    private String schoolname;

    /**
     * 专业名称
     */
    private String professionalTitle;

    /**
     * 学历
     */
    private String education;

    /**
     * 毕业时间
     */
    private Date graduationTime;

    private static final long serialVersionUID = 1L;
}