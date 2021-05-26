package com.cwl.qzzp.common;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/3/28
 * @description:状态码
 */
public enum RetCode {

    /*操作成功*/
    OK(0, "操作成功"),
    FAIL(1, "操作失败"),
    RELOAD(2, "'加载职位表数据失败'"),
    LOGINFAIL(3,"登录失败"),
    REGISTRATIONFAILED(4,"注册失败");


    public int code;
    public String msg;

    RetCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
