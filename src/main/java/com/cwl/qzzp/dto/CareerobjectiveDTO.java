package com.cwl.qzzp.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * careerobjective
 * @author 
 */
@Data
public class CareerobjectiveDTO implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 数据源
     */
    private String dataid;

    /**
     * 期待职位
     */
    private String position;

    /**
     * 期待城市
     */
    private String city;

    /**
     * 期待起薪from
     */
    private String startingSalaryFrom;

    /**
     * 期待起薪to
     */
    private String startingSalaryTo;

    private static final long serialVersionUID = 1L;
}