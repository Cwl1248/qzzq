package com.cwl.qzzp.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * userinfo
 * @author 
 */
@Data
public class UserinfoDTO implements Serializable {
    /**
     * 主键
     */
    private String userid;

    /**
     * 邮箱（用作登录名）
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别
     */
    private String gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 当前求职状态
     */
    private String jobhuntingstatus;

    /**
     * 身份
     */
    private String identitys;

    /**
     * 头像
     */
    private String heardimage;

    /**
     * 个人优势
     */
    private String personaladvantage;

    /**
     * 创建时间
     */
    private Date itemcreateat;

    /**
     * 简历路径
     */
    private String resumePath;

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