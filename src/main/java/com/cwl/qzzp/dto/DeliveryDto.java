package com.cwl.qzzp.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * delivery
 * @author 
 */
@Data
public class DeliveryDto implements Serializable {
    /**
     * 主键
     */
    private Integer itemid;

    /**
     * 职位ID
     */
    private String pid;

    /**
     * 求职者ID
     */
    private String uid;

    /**
     * 创建时间
     */
    private Date cratetime;

    /**
     * 职位名称
     */
    private String pname;

    private static final long serialVersionUID = 1L;
}