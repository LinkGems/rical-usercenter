package com.wtrue.rical.backend.consumer;

import com.wtrue.jobcenter.export.remote.IJobService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/6 12:13 AM
 */
@Configuration
public class ReferenceConsumer {

    @Reference(version = "${consumer.wtrue.job-center.IJobService}")
    public IJobService iJobService;
}
