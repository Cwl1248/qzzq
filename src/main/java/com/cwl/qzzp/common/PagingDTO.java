package com.cwl.qzzp.common;

import lombok.Data;

import java.util.List;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/4
 * @description：TODO
 */
@Data
public class PagingDTO<T> {
    /*数据列表*/
    private List<T> rows;
    /*当前页码*/
    private Integer page = 1;
    /*总页数*/
    private Integer total = 1;
    /*总记录数*/
    private Long records = 0L;
}
