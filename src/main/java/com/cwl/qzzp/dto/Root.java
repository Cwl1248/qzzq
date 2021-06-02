package com.cwl.qzzp.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * root
 * @author 
 */
@Data
public class Root implements Serializable {
    private Integer id;

    private String name;

    private String pwd;

    private static final long serialVersionUID = 1L;
}