package com.cwl.qzzp.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/27
 * @description：TODO
 */
@Data
public class ResultData<T> {


    private Integer status = 0;

    private String message;

    private T data;


    public static ResultData ok() {
        ResultData resultData = new ResultData();
        resultData.setStatus(RetCode.OK.code);
        resultData.setMessage(RetCode.OK.msg);
        return resultData;
    }

    public static <T> ResultData<T> ok(T data) {
        ResultData resultData = new ResultData();
        resultData.setStatus(RetCode.OK.code);
        resultData.setMessage(RetCode.OK.msg);
        resultData.setData(data);
        return resultData;
    }

    public static ResultData ok(RetCode ret, String msg) {
        ResultData resultData = new ResultData();
        resultData.setStatus(ret.code);
        resultData.setMessage(msg);
        return resultData;
    }

    public static ResultData failed(RetCode ret) {
        ResultData resultData = new ResultData();
        resultData.setStatus(ret.code);
        resultData.setMessage(ret.msg);
        return resultData;
    }

    public static ResultData failed(int code, String message) {
        ResultData resultData = new ResultData();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }

    public static ResultData failed(RetCode ret, String message) {
        ResultData resultData = new ResultData();
        resultData.setStatus(ret.code);
        resultData.setMessage(message);
        return resultData;
    }

    public static <T> ResultData<T> failed(int code, String message, T data) {
        ResultData resultData = new ResultData();
        resultData.setStatus(code);
        resultData.setMessage(message);
        resultData.setData(data);
        return resultData;
    }

    public String toJSON() {
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("status", status);
        jsonResult.put("message", message);
        jsonResult.put("data", null);
        return jsonResult.toJSONString();
    }
}
