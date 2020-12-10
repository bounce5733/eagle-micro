package com.eagle.micro.app.simple.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/3/1 14:55
 * @Version 1.0
 **/
@Data
@ConfigurationProperties("app.kafka")
public class KafkaProperties {

    private String servers;

    private String groupId;

    private String[] indexSourceTopic;

    private String[] indexSinkTopic;

}
