package com.cwl.qzzp.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * recruiterinfor
 * @author 
 */
@Data
public class RecruiterinforDTO implements Serializable {
    /**
     * 主键
     */
    private String itemid;

    /**
     * 公司的ID
     */
    private String dataid;

    /**
     * 招聘者名字
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 公司名称
     */
    private String companyname;

    /**
     * 职位名称
     */
    private String title;

    /**
     * 创建时间
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;
}