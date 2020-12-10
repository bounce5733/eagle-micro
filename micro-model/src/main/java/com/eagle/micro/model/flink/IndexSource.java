package com.eagle.micro.model.flink;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/9/9 13:48
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndexSource {

    private int seq;

    private String val;

    private String areaCode;

    private String submitChannel;

    private long timestamp;
}
