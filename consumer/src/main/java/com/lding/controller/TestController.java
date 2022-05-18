package com.lding.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@RestController
public class TestController {

    @JmsListener(destination = "${my-queue}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("*****消费者收到消息: " + textMessage.getText());
    }

}
