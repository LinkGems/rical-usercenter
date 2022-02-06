package com.wtrue.rical.backend.common.configs;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/18 10:22 PM
 */
@Slf4j
@Configuration
public class JobConfig {

    @Value("${dubbo.application.id}")
    private String appName;
    @Value("${job.admin.accessToken}")
    private String accessToken;
    @Value("${job.admin.address}")
    private String address;
    @Value("${job.admin.ip}")
    private String ip;
    @Value("${job.admin.adminAddresses}")
    private String adminAddresses;
    @Value("${job.admin.port}")
    private int port;
    @Value("${job.admin.logPath}")
    private String logPath;
    @Value("${job.admin.logRetentionDays}")
    private int logRetentionDays;

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appName);
        xxlJobSpringExecutor.setAddress(address);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobSpringExecutor;
    }
}
