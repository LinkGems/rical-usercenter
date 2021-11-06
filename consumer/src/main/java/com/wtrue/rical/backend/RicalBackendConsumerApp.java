package com.wtrue.rical.backend;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:44 PM
 */
@SpringBootApplication
@EnableDubbo
public class RicalBackendConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(RicalBackendConsumerApp.class);
    }
}
