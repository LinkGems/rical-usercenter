package com.wtrue.rical.backend.consumer;

import com.wtrue.jobcenter.export.remote.IJobProvider;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/6 12:13 AM
 */
@Configuration
public class ReferenceConsumer {

    @Reference(version = "${consumer.wtrue.job-center.IJobProvider}")
    public IJobProvider jobProvider;
}
