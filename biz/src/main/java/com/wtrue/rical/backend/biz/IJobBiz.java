package com.wtrue.rical.backend.biz;

import com.wtrue.rical.backend.domain.dto.JobInfoDTO;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/5 12:25 PM
 */
public interface IJobBiz {

    Boolean addJob(JobInfoDTO jobInfoDTO);

    JobInfoDTO queryJob(Integer jobId);
}
