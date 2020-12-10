package com.eagle.micro.model.flink;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndexEvent {

    private String seq;
    private long busiTime;
    private String bizType;
    private String subBizType;
    private String val;
    private Map<String, Object> props;
}
