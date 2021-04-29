package com.cwl.qzzp.util;

import java.util.UUID;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/27
 * @description：TODO
 */
public class GetUUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        String uuid = getUUID();
        System.out.println(uuid);
    }
}
