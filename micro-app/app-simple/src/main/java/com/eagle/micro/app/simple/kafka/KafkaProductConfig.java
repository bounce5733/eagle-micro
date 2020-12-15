package com.eagle.micro.app.simple.kafka;

import com.eagle.micro.model.flink.IndexSource;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/3/1 15:04
 * @Version 1.0
 **/
@Configuration
public class KafkaProductConfig {


    private final KafkaProperties kafkaProperties;

    public KafkaProductConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", kafkaProperties.getServers());
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", JsonSerializer.class);
        return props;
    }

    @Bean("kafkaIndexSourceTemplate")
    public KafkaTemplate<String, IndexSource> kafkaIndexSourceTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfigs()));
    }

}
