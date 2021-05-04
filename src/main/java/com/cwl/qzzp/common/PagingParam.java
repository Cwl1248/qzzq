package com.cwl.qzzp.common;

import lombok.Data;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/4
 * @description：TODO
 */
@Data
public class PagingParam {

    private Integer page = 1;
    private Integer rows = 10;
    private String sidx;
    private String sord;

    public void setPage(Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        this.page = page;
    }
}
