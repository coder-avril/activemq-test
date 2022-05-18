package com.lding.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Queue;

@Configuration
public class ActiveMqCfg {
    @Value("${my-queue}")
    private String name;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(name);
    }
}
