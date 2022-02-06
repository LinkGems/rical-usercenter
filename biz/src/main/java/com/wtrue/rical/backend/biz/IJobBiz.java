package com.wtrue.rical.backend.biz;

import com.wtrue.jobcenter.export.pojo.JobAddModel;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/5 12:25 PM
 */
public interface IJobBiz {

    Boolean addJob(JobAddModel jobAddModel);
}
