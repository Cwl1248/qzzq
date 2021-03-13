package com.cwl.qzzp.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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

    private static final long serialVersionUID = 1L;
}