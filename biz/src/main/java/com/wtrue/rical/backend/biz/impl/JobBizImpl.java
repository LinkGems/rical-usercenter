package com.wtrue.rical.backend.biz.impl;

import com.alibaba.fastjson.JSON;
import com.wtrue.jobcenter.export.pojo.JobAddModel;
import com.wtrue.jobcenter.export.remote.IJobProvider;
import com.wtrue.rical.backend.biz.IJobBiz;
import com.wtrue.rical.common.domain.BaseResponse;
import com.wtrue.rical.common.domain.ThreadLocalData;
import com.wtrue.rical.common.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/5 12:26 PM
 */
@Service
public class JobBizImpl implements IJobBiz {

    @Resource
    private IJobProvider iJobProvider;

    @Override
    public Boolean addJob(JobAddModel jobAddModel) {
        BaseResponse<Integer> response = iJobProvider.addJob(jobAddModel);
        return response.isSuccess();
    }
}