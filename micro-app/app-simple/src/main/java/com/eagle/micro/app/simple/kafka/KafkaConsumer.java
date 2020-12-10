package com.eagle.micro.app.simple.kafka;

import com.eagle.micro.model.flink.IndexEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "#{indexSinkTopic}", groupId = "#{topicGroupId}")
    public void processMessage(ConsumerRecord<String, IndexEvent> record) {
        log.info("Kafka 消费数据：" + record.value());
    }
}
