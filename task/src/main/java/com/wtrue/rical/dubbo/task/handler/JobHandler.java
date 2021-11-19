package com.wtrue.rical.dubbo.task.handler;

import com.wtrue.jobcenter.export.job.context.XxlJobHelper;
import com.wtrue.jobcenter.export.job.handler.IJobHandler;
import com.wtrue.jobcenter.export.job.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/18 10:14 PM
 */
@Component
public class JobHandler extends IJobHandler {

    @Override
    @XxlJob(value = "helloWtrueJobHandler")
    public void execute() throws Exception {
        XxlJobHelper.log("hello WTrue");
    }
}
