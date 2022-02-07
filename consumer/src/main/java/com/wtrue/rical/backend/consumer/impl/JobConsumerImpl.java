package com.wtrue.rical.backend.consumer.impl;

import com.wtrue.jobcenter.export.pojo.JobQueryModel;
import com.wtrue.jobcenter.export.remote.IJobProvider;
import com.wtrue.rical.backend.consumer.IJobConsumer;
import com.wtrue.rical.backend.domain.adapter.JobAdapter;
import com.wtrue.rical.backend.domain.dto.JobInfoDTO;
import com.wtrue.rical.common.domain.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/7 3:32 PM
 */
@Service
public class JobConsumerImpl implements IJobConsumer {

    @Resource
    private IJobProvider jobProvider;

    @Override
    public Boolean addJob(JobInfoDTO jobInfoDTO) {
        BaseResponse<Integer> response = jobProvider.addJob(JobAdapter.dto2AddMo(jobInfoDTO));
        return response.isSuccess();
    }

    @Override
    public JobInfoDTO queryJob(Integer jobId) {
        BaseResponse<JobQueryModel> response = jobProvider.queryJobById(jobId);
        if(response != null && response.isSuccess()){
            return JobAdapter.queryMo2dto(response.getData());
        }
        return null;
    }

}
