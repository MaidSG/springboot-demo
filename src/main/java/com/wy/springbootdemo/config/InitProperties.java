package com.wy.springbootdemo.config;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "init")
@Setter
@Getter
@ToString
public class InitProperties {
    private String info;
    private String key;
    private List<Message> messages;

    @Setter
    @Getter
    @ToString
    static class Message {
        String id;
        String desc;
    }
}
