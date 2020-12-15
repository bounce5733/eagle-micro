package com.eagle.micro.app.simple.kafka;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/3/1 14:55
 * @Version 1.0
 **/
@Data
@Configuration
@NacosConfigurationProperties(dataId = "kafka", groupId = "MIDDLEWARE", type = ConfigType.YAML, autoRefreshed = true)
public class KafkaProperties {

    private String servers;

    private String groupId;

    private String[] indexSourceTopic;

    private String[] indexSinkTopic;

}
