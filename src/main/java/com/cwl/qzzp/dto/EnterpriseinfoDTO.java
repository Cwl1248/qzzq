package com.cwl.qzzp.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * enterpriseinfo
 * @author 
 */
@Data
public class EnterpriseinfoDTO implements Serializable {
    /**
     * 主键
     */
    private String eid;

    /**
     * 公司Logo
     */
    private String logoimage;

    /**
     * 公司名称
     */
    private String ename;

    /**
     * 公司地址
     */
    private String eplace;

    /**
     * 宣传语
     */
    private String signlanguage;

    /**
     * 公司介绍
     */
    private String eintroducation;

    /**
     * 融资阶段
     */
    private String financingstage;

    /**
     * 行业类别
     */
    private String category;

    /**
     * 公司网站链接
     */
    private String eurl;

    /**
     * 公司环境介绍1
     */
    private String eimage1;

    /**
     * 公司环境介绍2
     */
    private String eimage2;

    /**
     * 公司环境介绍3
     */
    private String eimage3;

    /**
     * 面试评价数量
     */
    private Integer evaluationnum;

    /**
     * 在招职位数量
     */
    private Integer positionnum;

    /**
     * 简历处理率
     */
    private Double dealrate;

    /**
     * 福利一
     */
    private String benefit1;

    /**
     * 福利二
     */
    private String benefit2;

    /**
     * 福利三
     */
    private String benefit3;

    /**
     * 福利四
     */
    private String benefit4;

    /**
     * 福利五
     */
    private String benefit5;

    /**
     * 浏览次数
     */
    private Integer visitnum;

    /**
     * 员工人数
     */
    private Integer numberofworkers;

    private static final long serialVersionUID = 1L;
}