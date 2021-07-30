package com.example.newproject.common.util;

import java.math.BigDecimal;

/**
 * 作者：韩宇 on 2017/6/21 0021 13:50
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：加减乘除的计算
 */
public class MathUtil {
    public static double add(String d1, String d2) {        // 进行加法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.add(b2).doubleValue();
    }

    public static double sub(String d1, String d2) {        // 进行减法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.subtract(b2).doubleValue();
    }

    public static double mul(String d1, String d2) {        // 进行乘法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.multiply(b2).doubleValue();
    }

    public static double div(String d1,
                             String d2, int len) {          // 进行除法运算
        // 进行除法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.divide(b2, len, BigDecimal.
                ROUND_HALF_UP).doubleValue();
    }

    public static double round(String d,
                               int len) {                   // 进行求余运算
        // 进行四舍五入操作
        BigDecimal b1 = new BigDecimal(d);
        BigDecimal b2 = new BigDecimal(1);
        return b1.divide(b2, len, BigDecimal.
                ROUND_HALF_UP).doubleValue();
    }
}
