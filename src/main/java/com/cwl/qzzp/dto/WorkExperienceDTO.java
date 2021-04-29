package com.cwl.qzzp.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * work_experience
 *
 * @author
 */
@Data
public class WorkExperienceDTO implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 数据源
     */
    private String dataid;

    /**
     * 公司名称
     */
    private String companyname;

    /**
     * 公司行业
     */
    private String companyIndustry;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 职位类型
     */
    private String tybeOfJob;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 工作时间
     */
    private String operatingHours;

    private static final long serialVersionUID = 1L;
}