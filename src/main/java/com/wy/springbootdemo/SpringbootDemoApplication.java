package com.wy.springbootdemo;

import com.wy.springbootdemo.config.InitProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication implements InitializingBean {

    private final InitProperties initProperties;

    public SpringbootDemoApplication(InitProperties initProperties) {
        this.initProperties = initProperties;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println(initProperties.toString());
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
