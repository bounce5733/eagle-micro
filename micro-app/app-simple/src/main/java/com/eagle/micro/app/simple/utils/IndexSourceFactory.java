package com.eagle.micro.app.simple.utils;

import com.eagle.micro.model.flink.IndexSource;

import java.util.Random;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/9/6 19:07
 * @Version 1.0
 **/
public class IndexSourceFactory {

    private static int COUNT = 0;

    private static final String[] AREA_CODE = {"330000", "331000", "340000", "341000"};

    private static final String[] SUBMIT_CHANNEL = {"JD", "YZF", "HB", "XC"};

    public static IndexSource create() {

        return IndexSource.builder().seq(COUNT++).areaCode(AREA_CODE[new Random().nextInt(AREA_CODE.length)])
                .submitChannel(SUBMIT_CHANNEL[new Random().nextInt(SUBMIT_CHANNEL.length)])
                .timestamp(System.currentTimeMillis())
                .val(String.valueOf(new Random().nextInt(10)))
                .build();
    }
}

