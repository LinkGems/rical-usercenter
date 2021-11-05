package com.wtrue.sprica.dubbo.config;

import com.wtrue.sprica.dubbo.export.ITestProvider;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/6 12:13 AM
 */
@Configuration
public class ReferenceConfig {

    @Reference(version = "${wt-service.sprica-dubbo-provider.version}")
    public ITestProvider testProvider;
}
