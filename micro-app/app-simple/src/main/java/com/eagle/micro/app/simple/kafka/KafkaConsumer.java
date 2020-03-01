package com.eagle.micro.app.simple.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/3/1 16:15
 * @Version 1.0
 **/
@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "#{kafkaTopicNames}", groupId = "#{topicGroupId}")
    public void processMessage(ConsumerRecord<String, String> record) {
        log.info("Kafka 消费数据：" + record.value());
    }
}
