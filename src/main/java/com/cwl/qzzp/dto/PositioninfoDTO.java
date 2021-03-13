package com.cwl.qzzp.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * positioninfo(职位信息表)
 * @author 
 */
@Data
public class PositioninfoDTO implements Serializable {
    /**
     * 主键
     */
    private String pid;

    /**
     * 父ID
     */
    private String dataid;

    /**
     * 职位名称
     */
    private String ptitle;

    /**
     * 薪资
     */
    private String salary;

    /**
     * 经验要求
     */
    private String experience;

    /**
     * 工作地点
     */
    private String place;

    /**
     * 职位诱惑
     */
    private String temptation;

    /**
     * 职位描述
     */
    private String description;

    /**
     * 所属部门
     */
    private String departments;

    /**
     * 职位发布状态
     */
    private String states;

    /**
     * 发布时间
     */
    private Date releasetime;

    /**
     * 浏览次数
     */
    private Integer visitnum;

    private static final long serialVersionUID = 1L;
}