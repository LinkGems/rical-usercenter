package com.wtrue.sprica.dubbo;

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
public class ProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class);
    }
}
