package com.eagle.micro.app.simple.kafka;

import com.eagle.micro.model.flink.IndexSource;
import com.eagle.micro.app.simple.utils.IndexSourceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private static float AMOUNT = 0;

    private static int COUNT = 0;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Autowired
    @Qualifier("kafkaIndexSourceTemplate")
    private KafkaTemplate<String, IndexSource> kafkaIndexSourceTemplate;

    @Scheduled(fixedDelay = 1000)
    public void sendIndexSource() {
        IndexSource index = IndexSourceFactory.create();
        String topic = kafkaProperties.getIndexSourceTopic()[0];
        ListenableFuture<SendResult<String, IndexSource>> future = kafkaIndexSourceTemplate.send(topic, index);
        future.addCallback(new ListenableFutureCallback<SendResult<String, IndexSource>>() {

            @SneakyThrows
            @Override
            public void onSuccess(SendResult<String, IndexSource> result) {
                log.info("kafka 发送指标：序号{},内容{}", COUNT++, new ObjectMapper().writeValueAsString(index));
            }

            @SneakyThrows
            @Override
            public void onFailure(Throwable ex) {
                log.error("Kafka 发送消息失败，主题：{}，数据：{}，异常：{}", topic, new ObjectMapper().writeValueAsString(index), ex);
            }
        });
    }

}
