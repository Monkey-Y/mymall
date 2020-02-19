package com.mmall.util;

import java.math.BigDecimal;

/**
 * 价格计算一定要使用BigDecimal的String构造器，但是我们数据库中存放的数据类型是Double
 * 所以要经常做String和Double的转换比较麻烦，所以才写了此工具类
 */
public class BigDecimalUtil {

    //这个工具类不能让在外部实例化，所以写一个私有构造器
    private BigDecimalUtil(){

    }

    //加法
    public static BigDecimal add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    //减法
    public static BigDecimal sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    //乘法
    public static BigDecimal mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    //除法
    public static BigDecimal div(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);//保留2位小数,四舍五入

        //除不尽的情况
    }





}
