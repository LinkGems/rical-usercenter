package com.wtrue.rical.backend.domain.adapter;

import com.wtrue.jobcenter.export.pojo.JobAddModel;
import com.wtrue.jobcenter.export.pojo.JobQueryModel;
import com.wtrue.rical.backend.domain.dto.JobInfoDTO;
import com.wtrue.rical.backend.domain.vo.req.JobAddReq;
import com.wtrue.rical.backend.domain.vo.resp.JobInfoResp;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/7 2:18 PM
 */
public class JobAdapter {

    public static JobInfoDTO addReq2dto(JobAddReq req) {
        if (req == null) {
            return null;
        }
        JobInfoDTO jobInfoDTO = new JobInfoDTO();
        jobInfoDTO.setAuthor(req.getAuthor());
        jobInfoDTO.setScheduleType(req.getScheduleType());
        jobInfoDTO.setScheduleConf(req.getScheduleConf());
        jobInfoDTO.setGlueType(req.getGlueType());
        jobInfoDTO.setMisfireStrategy(req.getMisfireStrategy());
        jobInfoDTO.setExecutorRouteStrategy(req.getExecutorRouteStrategy());
        jobInfoDTO.setExecutorHandler(req.getExecutorHandler());
        jobInfoDTO.setExecutorParam(req.getExecutorParam());
        jobInfoDTO.setExecutorBlockStrategy(req.getExecutorBlockStrategy());
        jobInfoDTO.setExecutorTimeout(req.getExecutorTimeout());
        jobInfoDTO.setExecutorFailRetryCount(req.getExecutorFailRetryCount());
        return jobInfoDTO;
    }

    public static JobAddModel dto2AddMo(JobInfoDTO jobInfoDTO) {
        if (jobInfoDTO == null) {
            return null;
        }
        JobAddModel jobAddModel = new JobAddModel();
        jobAddModel.setBusinessId(jobInfoDTO.getBusinessId());
        jobAddModel.setAuthor(jobInfoDTO.getAuthor());
        jobAddModel.setScheduleType(jobInfoDTO.getScheduleType());
        jobAddModel.setScheduleConf(jobInfoDTO.getScheduleConf());
        jobAddModel.setGlueType(jobInfoDTO.getGlueType());
        jobAddModel.setMisfireStrategy(jobInfoDTO.getMisfireStrategy());
        jobAddModel.setExecutorRouteStrategy(jobInfoDTO.getExecutorRouteStrategy());
        jobAddModel.setExecutorHandler(jobInfoDTO.getExecutorHandler());
        jobAddModel.setExecutorParam(jobInfoDTO.getExecutorParam());
        jobAddModel.setExecutorBlockStrategy(jobInfoDTO.getExecutorBlockStrategy());
        jobAddModel.setExecutorTimeout(jobInfoDTO.getExecutorTimeout());
        jobAddModel.setExecutorFailRetryCount(jobInfoDTO.getExecutorFailRetryCount());
        jobAddModel.setChildJobId(jobInfoDTO.getChildJobId());
        return jobAddModel;
    }

    public static JobInfoDTO queryMo2dto(JobQueryModel jobQueryModel) {
        if (jobQueryModel == null) {
            return null;
        }
        JobInfoDTO jobInfoDTO = new JobInfoDTO();
        jobInfoDTO.setJobId(jobQueryModel.getJobId());
        jobInfoDTO.setBusinessId(jobQueryModel.getBusinessId());
        jobInfoDTO.setAuthor(jobQueryModel.getAuthor());
        jobInfoDTO.setScheduleType(jobQueryModel.getScheduleType());
        jobInfoDTO.setScheduleConf(jobQueryModel.getScheduleConf());
        jobInfoDTO.setGlueType(jobQueryModel.getGlueType());
        jobInfoDTO.setMisfireStrategy(jobQueryModel.getMisfireStrategy());
        jobInfoDTO.setExecutorRouteStrategy(jobQueryModel.getExecutorRouteStrategy());
        jobInfoDTO.setExecutorHandler(jobQueryModel.getExecutorHandler());
        jobInfoDTO.setExecutorParam(jobQueryModel.getExecutorParam());
        jobInfoDTO.setExecutorBlockStrategy(jobQueryModel.getExecutorBlockStrategy());
        jobInfoDTO.setExecutorTimeout(jobQueryModel.getExecutorTimeout());
        jobInfoDTO.setExecutorFailRetryCount(jobQueryModel.getExecutorFailRetryCount());
        jobInfoDTO.setTriggerStatus(jobQueryModel.getTriggerStatus());
        jobInfoDTO.setTriggerLastTime(jobQueryModel.getTriggerLastTime());
        jobInfoDTO.setTriggerNextTime(jobQueryModel.getTriggerNextTime());
        jobInfoDTO.setChildJobId(jobQueryModel.getChildJobId());
        return jobInfoDTO;
    }

    public static JobInfoResp dto2resp(JobInfoDTO jobInfoDTO) {
        if (jobInfoDTO == null) {
            return null;
        }
        JobInfoResp jobInfoResp = new JobInfoResp();
        jobInfoResp.setJobId(jobInfoDTO.getJobId());
        jobInfoResp.setBusinessId(jobInfoDTO.getBusinessId());
        jobInfoResp.setAuthor(jobInfoDTO.getAuthor());
        jobInfoResp.setScheduleType(jobInfoDTO.getScheduleType());
        jobInfoResp.setScheduleConf(jobInfoDTO.getScheduleConf());
        jobInfoResp.setGlueType(jobInfoDTO.getGlueType());
        jobInfoResp.setMisfireStrategy(jobInfoDTO.getMisfireStrategy());
        jobInfoResp.setExecutorRouteStrategy(jobInfoDTO.getExecutorRouteStrategy());
        jobInfoResp.setExecutorHandler(jobInfoDTO.getExecutorHandler());
        jobInfoResp.setExecutorParam(jobInfoDTO.getExecutorParam());
        jobInfoResp.setExecutorBlockStrategy(jobInfoDTO.getExecutorBlockStrategy());
        jobInfoResp.setExecutorTimeout(jobInfoDTO.getExecutorTimeout());
        jobInfoResp.setExecutorFailRetryCount(jobInfoDTO.getExecutorFailRetryCount());
        jobInfoResp.setTriggerStatus(jobInfoDTO.getTriggerStatus());
        jobInfoResp.setTriggerLastTime(jobInfoDTO.getTriggerLastTime());
        jobInfoResp.setTriggerNextTime(jobInfoDTO.getTriggerNextTime());
        jobInfoResp.setChildJobId(jobInfoDTO.getChildJobId());
        return jobInfoResp;
    }
}
