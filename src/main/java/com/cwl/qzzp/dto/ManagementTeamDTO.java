package com.cwl.qzzp.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * managementteam(企业管理者团队)
 * @author 
 */
@Data
public class ManagementTeamDTO implements Serializable {
    /**
     * 主键
     */
    private String mids;

    /**
     * 父ID
     */
    private String dataid;

    /**
     * 管理者名字
     */
    private String mname;

    /**
     * 管理者介绍
     */
    private String mintroducation;

    /**
     * 管理者职位描述
     */
    private String pmintroducation;

    private static final long serialVersionUID = 1L;
}