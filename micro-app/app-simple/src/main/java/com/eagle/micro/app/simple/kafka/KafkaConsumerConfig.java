package com.eagle.micro.app.simple.kafka;

import com.eagle.micro.model.flink.IndexEvent;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

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
@EnableKafka
public class KafkaConsumerConfig {

    private final KafkaProperties kafkaProperties;

    public KafkaConsumerConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", kafkaProperties.getServers());
        props.put("key.deserializer", StringDeserializer.class);
        props.put("value.deserializer", JsonDeserializer.class);
        return props;
    }

    @Bean
    public ConsumerFactory<String, IndexEvent> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(IndexEvent.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, IndexEvent> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, IndexEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public String[] indexSinkTopic() {
        return kafkaProperties.getIndexSinkTopic();
    }

    @Bean
    public String topicGroupId() {
        return kafkaProperties.getGroupId();
    }
}
