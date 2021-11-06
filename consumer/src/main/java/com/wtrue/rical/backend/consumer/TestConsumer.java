package com.wtrue.rical.backend.consumer;

import com.wtrue.rical.backend.export.ITestProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 5:04 PM
 */
@RestController
@RequestMapping("/test/")
public class TestConsumer {

    @Autowired
    private ITestProvider testProvider;

    @GetMapping("add")
    public String add(int num){
        return testProvider.add(num);
    }
}
