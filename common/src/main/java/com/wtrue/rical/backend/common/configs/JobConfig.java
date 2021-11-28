package com.wtrue.rical.backend.common.configs;

import com.wtrue.jobcenter.export.job.executor.impl.XxlJobSpringExecutor;
import com.wtrue.jobcenter.export.remote.IJobService;
import com.wtrue.rical.common.utils.HttpUtil;
import com.wtrue.rical.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    private static String accessToken;
    private String address;
    private String ip;
    private final static String adminAddresses = "http://103.45.105.132:8080/xxl-job-admin";
    private final static int port = 9999;
    private final static String logPath = "/data/applogs/xxl-job/jobhandler";
    private final static int logRetentionDays = 30;

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
