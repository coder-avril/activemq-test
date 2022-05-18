package com.lding.controller;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.UUID;

@RestController
public class ProducerController {
    @Resource
    private JmsMessagingTemplate template;
    @Resource
    private Queue queue;
    @Resource
    private Topic topic;

    @GetMapping("/sendQueue")
    public String sendQueue() {
        String result = "消息已经成功发到MQ！";
        try {
            this.template.convertAndSend(queue, "****: " +
                    UUID.randomUUID().toString().substring(0, 6));
        } catch (Exception e) {
            result = "发送失败，原因为: " + e.getMessage();
        }
        return result;
    }

    @GetMapping("/sendTopic")
    public String sendTopic() {
        String result = "消息已经成功发到MQ！";
        try {
            this.template.convertAndSend(topic, "****: " +
                    UUID.randomUUID().toString().substring(0, 6));
        } catch (Exception e) {
            result = "发送失败，原因为: " + e.getMessage();
        }
        return result;
    }
}
