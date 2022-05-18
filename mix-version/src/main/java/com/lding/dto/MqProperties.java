package com.lding.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties("mq-properties")
@Component
public class MqProperties {
    private String user;
    private String password;
    private String brokerUrl;
    private String queueName;
    private String topicName;
}
