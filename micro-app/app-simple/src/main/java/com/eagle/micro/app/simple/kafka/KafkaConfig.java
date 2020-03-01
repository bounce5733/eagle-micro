package com.eagle.micro.app.simple.kafka;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/3/1 15:04
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties(TopicProperties.class)
public class KafkaConfig {

    private final TopicProperties topicProps;

    public KafkaConfig(TopicProperties topicProps) {
        this.topicProps = topicProps;
    }

    @Bean
    public String[] kafkaTopicNames() {
        return topicProps.getTopicNames();
    }

    @Bean
    public String topicGroupId() {
        return topicProps.getGroupId();
    }
}
