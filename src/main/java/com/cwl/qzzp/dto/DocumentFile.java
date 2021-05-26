package com.cwl.qzzp.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/25
 * @description：文件上传下载
 */
@Data
public class DocumentFile {
    private Integer id;
    private String name;
    private String path;
    private Date time;
}

