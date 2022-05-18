package com.lding.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms // 自动扫描带有@JmsListener的Bean方法,并为其创建一个MessageListener把它包装起来
public class ActiveMqCfg {
    // 暂时可以不用写任何东西
}
