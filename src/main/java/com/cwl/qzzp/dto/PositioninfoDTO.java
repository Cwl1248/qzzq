package com.cwl.qzzp.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * positioninfo
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
     * 招聘者id
     */
    private String reid;

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
     * 职位的性质（全职/兼职/实习）
     */
    private String postnature;

    /**
     * 职位分类1
     */
    private String posttype1;

    /**
     * 职位分类2
     */
    private String posttype2;

    /**
     * 职位分类3
     */
    private String posttype3;

    /**
     * 职位分类4
     */
    private String posttype4;

    /**
     * 职位分类5
     */
    private String posttype5;

    /**
     * 发布时间
     */
    private Date releasetime;

    /**
     * 浏览次数
     */
    private Integer visitnum;

    /**
     * 学历要求
     */
    private String education;

    private static final long serialVersionUID = 1L;
}