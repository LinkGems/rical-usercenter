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
    private static String appName;
    @Value("${xxl.job.admin.accessToken}")
    private static String accessToken;
    @Value("${xxl.job.admin.address}")
    private static String address;
    @Value("${xxl.job.admin.ip}")
    private static String ip;
    @Value("${xxl.job.admin.adminAddresses}")
    private static String adminAddresses;
    @Value("${xxl.job.admin.port}")
    private static int port;
    @Value("${xxl.job.admin.logPath}")
    private static String logPath;
    @Value("${xxl.job.admin.logRetentionDays}")
    private static int logRetentionDays;

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
