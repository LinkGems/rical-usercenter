package com.whitrue.rical.backend.biz;

import com.whitrue.jobcenter.export.pojo.JobAddModel;
import com.whitrue.rical.backend.domain.dto.JobInfoDTO;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/5 12:25 PM
 */
public interface IJobBiz {

    Boolean addJob(JobInfoDTO jobInfoDTO);

    JobInfoDTO queryJob(Integer jobId);
}
