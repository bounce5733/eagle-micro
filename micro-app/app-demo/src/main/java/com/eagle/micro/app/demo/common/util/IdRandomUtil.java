package com.eagle.micro.app.demo.common.util;

/**
 * 工具类放在common.util下
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 17:28
 * @Version 1.0
 **/
public class IdRandomUtil {


    /**
     * 产生随机数ID 时间戳+随机数
     *
     * @return long
     */
    public static long create() {
        long time = System.currentTimeMillis();
        long random = new Double(Math.random() * 1000).longValue();
        return time * 1000 + random;
    }
}
