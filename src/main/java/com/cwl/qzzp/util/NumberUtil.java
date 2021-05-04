package com.cwl.qzzp.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/4
 * @description：TODO
 */
@Component
public class NumberUtil {
    private static String UPCASE = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static String DOWNCASE = "qwertyuiopasdfghjklzxcvbnm";
    private static String NUMBER = "0123456789";


    /**
     * 生成编号
     *
     * @param type   编号类型
     * @param prefix 前缀
     * @return 编号
     */
    /*public String genNO(FlowNOEnum type, String... prefix) {
        int flowno;
        //订单编号使用随机数
        switch (type) {
            case USE_CONTRACT_NO:
            case PLEDGE_CONTRACT_NO:
            case MONEY_NO:
            case BAR_CODE:
            default:
                flowno = redisUtil.increment(type.name(), type.period).intValue();
                break;
        }
        prefix = prefix == null ? new String[]{""} : prefix;
        StringBuffer sb = new StringBuffer();
        sb.append(type.subfix);
        for (String p : prefix) {
            p = StringUtils.isNotEmpty(p) ? p : "";
            sb.append(p);
        }
        sb.append(formatNumToLength(flowno, type.length));
        return sb.toString();
    }*/

    /**
     * 生成随机字符串
     *
     * @param length 长度
     * @param type   字符类型
     * @return 随机字符串
     */

   /* public String genRandomStr(int length, RandomStrEnum type) {
        switch (type) {
            case UPCASE_ONLY:
                return genRandomStr(length, UPCASE);
            case DOWNCASE_ONLY:
                return genRandomStr(length, DOWNCASE);
            case NUMBER_ONLY:
                return genRandomStr(length, NUMBER);
            case UPCASE_NUMBER:
                return genRandomStr(length, UPCASE + NUMBER);
            case DOWNCASE_NUMBER:
                return genRandomStr(length, DOWNCASE + NUMBER);
            case UPCASE_DOWNCASE:
                return genRandomStr(length, UPCASE + DOWNCASE);
            case UPCASE_DOWNCASE_NUMBER:
                return genRandomStr(length, UPCASE + DOWNCASE + NUMBER);
            default:
                return genRandomStr(length, UPCASE);
        }
    }*/

    /**
     * 获取随机字符串
     *
     * @param length 字符长度
     * @param base   字符内容
     * @return 随机字符串
     */

    public String genRandomStr(int length, String base) {
        StringBuffer stringBuffer = new StringBuffer();
        int index;
        for (int i = 0; i < length; i++) {
            index = (int) (Math.random() * base.length());
            stringBuffer.append(base.charAt(index));
        }
        return stringBuffer.toString();
    }

    /**
     * 格式化数字,填充至指定长度
     *
     * @param num 数字
     * @param len 长度
     * @return 格式化后数字
     */

    public String formatNumToLength(int num, int len) {
        return formatNumToLength(num, len, "0");
    }

    /**
     * 格式化数字,填充至指定长度
     *
     * @param num 数字
     * @param len 长度
     * @param sep 填充字符,默认0
     * @return 格式化后数字
     */

    public String formatNumToLength(int num, int len, String sep) {
        if (null == sep) {
            sep = "0";
        }
        StringBuffer sb = new StringBuffer();
        String numStr = num + "";
        for (int i = numStr.length(); i < len; i++) {
            sb.append(sep);
        }
        sb.append(numStr);

        return sb.substring(sb.length() - len);
    }

    /**
     * 格式化小数
     *
     * @param src 数字
     * @param len 要保留的位数(不能为0)
     * @return 格式化后小数
     */

    public double formatNum(double src, int len) {
        src = src + 0.0000000001;
        BigDecimal decimal = new BigDecimal(src);
        return decimal.setScale(len, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 根据数据量总数和每页数量获取总页数
     *
     * @param limit        每页数量
     * @param totalRecords 数据量总数
     * @return 总页数
     */

    public static int getTotalPageNum(int limit, int totalRecords) {
        int result = 1;

        try {
            if (totalRecords <= 0 || limit <= 0 || limit >= totalRecords) {
                result = 1;
            } else if (totalRecords % limit == 0) {
                //能整除
                result = totalRecords / limit;
            } else {
                //9/2=4   需要5页
                result = totalRecords / limit + 1;
            }
        } catch (Exception e) {
            return 1;
        }
        return result;
    }
}
