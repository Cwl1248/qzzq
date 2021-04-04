package com.cwl.qzzp.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * managementteam
 * @author 
 */
@Data
public class ManagementteamDTO implements Serializable {
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