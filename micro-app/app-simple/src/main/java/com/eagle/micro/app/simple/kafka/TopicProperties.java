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
@ConfigurationProperties("app.kafka.topic")
public class TopicProperties {

    private String groupId;

    private String[] topicNames;

}
