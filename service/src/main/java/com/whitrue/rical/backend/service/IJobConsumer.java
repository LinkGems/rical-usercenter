package com.whitrue.rical.backend.service;

import com.whitrue.rical.backend.domain.dto.JobInfoDTO;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/7 3:33 PM
 */
public interface IJobConsumer {

    Boolean addJob(JobInfoDTO jobInfoDTO);

    JobInfoDTO queryJob(Integer jobId);
}
