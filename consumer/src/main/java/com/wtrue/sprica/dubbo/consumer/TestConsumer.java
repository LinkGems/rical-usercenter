package com.wtrue.sprica.dubbo.consumer;

import com.wtrue.sprica.dubbo.export.ITestProvider;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 5:04 PM
 */
@RestController("test")
public class TestConsumer {

    @Reference(version = "${wt-service.sprica-dubbo-provider.version}")
    private ITestProvider testProvider;

    @GetMapping("add")
    public String add(int num){
        return testProvider.add(num);
    }
}
