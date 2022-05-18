package com.lding.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@Service
public class ConsumerService {
    @JmsListener(destination = "${mq-properties.queue-name}", containerFactory = "jmsListenerContainerQueue")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("*****消费者收到Queue消息: " + textMessage.getText());
    }

    @JmsListener(destination = "${mq-properties.topic-name}", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic(TextMessage textMessage) throws JMSException {
        System.out.println("*****消费者收到Topic消息: " + textMessage.getText());
    }
}
