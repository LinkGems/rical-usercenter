package com.wtrue.rical.backend.task.handler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/18 10:14 PM
 */
@Component
public class JobHandler extends IJobHandler {

    @Override
    @XxlJob(value = "backendJobHandler")
    public void execute() throws Exception {
        String jobParam = XxlJobHelper.getJobParam();
        XxlJobHelper.log("hello wtrue BE");
    }
}
