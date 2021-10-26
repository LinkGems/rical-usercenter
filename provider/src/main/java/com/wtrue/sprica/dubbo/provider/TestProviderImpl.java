package com.wtrue.sprica.dubbo.provider;

import com.wtrue.sprica.dubbo.export.ITestProvider;
import org.apache.dubbo.config.annotation.Service;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:51 PM
 */
@Service(version = "${wt-service.sprica-dubbo-provider.version}")
public class TestProviderImpl implements ITestProvider {
    @Override
    public String add(int num) {
        return num + "!";
    }
}
