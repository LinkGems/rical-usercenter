package com.wtrue.rical.backend.task.config;

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
public class XxlJobConfig {

    @Value("${dubbo.application.id}")
    private String appName;
    private static String accessToken;
    private String address;
    private String ip;
    private final static String adminAddresses = "http://103.45.105.132:8080/xxl-job-admin";
    private final static int port = 9999;
    private final static String logPath = "/data/applogs/xxl-job/jobhandler";
    private final static int logRetentionDays = 30;

    @Resource
    private IJobService iJobService;

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

        // 注册handler
        iJobService.addJobGroupIfNx(appName);

        return xxlJobSpringExecutor;
    }

    /**
     * 如果不存在的话，注册handler
     */
    private void registerHandlerIfNX(){
        try{
            Map<String, String> params = new HashMap<>();
            params.put("appName", appName);
            String resp = HttpUtil.doPost(adminAddresses + "/handler/register", params);
            if(StringUtil.isNotEmpty(resp)){
                log.info("registerHandlerIfNX success, appName is {}, resp is {}", appName, resp);
            }else{
                log.error("registerHandlerIfNX error, appName is {}, may cause current service is job-center", appName);
            }
        }catch (Exception e){
            log.error("registerHandlerIfNX error, appName is {}, may cause current service is job-center", appName, e);
        }

    }
}
