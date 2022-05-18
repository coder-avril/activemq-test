package com.lding.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Topic;

@Configuration
public class ActiveMqCfg {
    @Value("${my-topic}")
    private String myTopic;

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(myTopic);
    }
}
