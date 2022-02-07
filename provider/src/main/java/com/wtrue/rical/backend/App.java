package com.wtrue.rical.backend;

import com.wtrue.rical.backend.reference.ConsumerReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:44 PM
 */
@MapperScan("com.wtrue.rical.backend.dao.mapper")
@SpringBootApplication
@EnableDubbo
public class App {

    @Autowired
    private ConsumerReference consumerReference;

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
