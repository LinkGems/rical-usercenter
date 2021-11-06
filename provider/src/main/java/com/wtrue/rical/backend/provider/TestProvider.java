package com.wtrue.rical.backend.provider;

import com.wtrue.rical.backend.export.ITestProvider;
import org.apache.dubbo.config.annotation.Service;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:51 PM
 */
@Service(version = "${wtrue.rical.backend}")
public class TestProvider implements ITestProvider {
    @Override
    public String add(int num) {
        return num + "!";
    }
}
