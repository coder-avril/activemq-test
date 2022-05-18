package com.lding.controller;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.jms.Queue;
import java.util.UUID;

@RestController
public class TestController {
    @Resource
    private JmsMessagingTemplate template;
    @Resource
    private Queue queue;

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

    /**
     * 每隔10秒自动发送消息
     */
    @Scheduled(fixedDelay = 10_000)
    private void scheduledMsg() {
        this.template.convertAndSend(queue, "****Scheduled: " +
                UUID.randomUUID().toString().substring(0, 6));
        System.out.println("已经向MQ周期性（间隔10秒）地发送消息！");
    }
}
