package com.eagle.micro.app.simple.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/3/1 17:23
 * @Version 1.0
 **/
@Slf4j
@Service
public class KafkaProducer {

    @Autowired
    private TopicProperties topicProps;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedDelay = 1 * 60 * 1000)
    public void sendMessage() {
        log.info("Kafka开始生产数据...");
        String data = "kafka测试数据...";
        String topic = topicProps.getTopicNames()[0];
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Kafka 成功发送消息，主题：{}，数据：{}", topic, data);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Kafka 发送消息失败，主题：{}，数据：{}，异常：{}", topic, data, ex);
            }
        });
        log.info("Kafka生产数据结束...");
    }

}
