package com.wtrue.rical.backend.task.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/11/22 11:12 AM
 */
@Component
public class TestJob {

    @XxlJob("backendTestHandler")
    public void demoJobHandler() throws Exception {
        String curTime = DateUtil.formatDateTime(new Date());
        XxlJobHelper.log("[backendTestHandler] 现在系统化时间为：" + curTime);
    }
}
