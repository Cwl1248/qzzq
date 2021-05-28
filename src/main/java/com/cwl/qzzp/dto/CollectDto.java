package com.cwl.qzzp.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * collect
 * @author 
 */
@Data
public class CollectDto implements Serializable {
    /**
     * 主键
     */
    private Integer itemid;

    /**
     * 职位ID
     */
    private String pid;

    /**
     * 收藏者ID
     */
    private String uid;

    /**
     * 职位名称
     */
    private String ptitle;

    /**
     * 薪资
     */
    private String salary;

    /**
     * 工作地点
     */
    private String place;

    /**
     * 所属部门
     */
    private String departments;

    /**
     * 创建时间
     */
    private Date cratetime;

    private static final long serialVersionUID = 1L;
}