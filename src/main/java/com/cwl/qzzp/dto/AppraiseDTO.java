package com.cwl.qzzp.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * appraise（评价表）
 * @author 
 */
@Data
public class AppraiseDTO implements Serializable {
    /**
     * 主键
     */
    private String itemid;

    /**
     * 评论者ID
     */
    private String userid;

    /**
     * 综合评分
     */
    private Double multiplescore;

    /**
     * 描述相符
     */
    private Double matchscore;

    /**
     * 对面试官的评分
     */
    private Double ratingtheinterviewe;

    /**
     * 公司环境评分
     */
    private Double environment;

    /**
     * 面试过程
     */
    private String interviewprocess;

    /**
     * 面试岗位Id
     */
    private String dataid;

    /**
     * 评价标签1
     */
    private String evaluationlabel1;

    /**
     * 评价标签2
     */
    private String evaluationlabel2;

    /**
     * 评价标签3
     */
    private String evaluationlabel3;

    /**
     * 评价标签4
     */
    private String evaluationlabel4;

    /**
     * 评价标签5
     */
    private String evaluationlabel5;

    /**
     * 创建时间
     */
    private Date cratetime;

    private static final long serialVersionUID = 1L;
}