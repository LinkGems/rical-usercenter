package com.whitrue.rical.backend.controller;

import com.whitrue.rical.backend.biz.IJobBiz;
import com.whitrue.rical.backend.domain.adapter.JobAdapter;
import com.whitrue.rical.backend.domain.dto.JobInfoDTO;
import com.whitrue.rical.backend.domain.vo.req.JobAddReq;
import com.whitrue.rical.backend.domain.vo.resp.JobInfoResp;
import com.whitrue.rical.common.domain.BaseResponse;
import com.whitrue.rical.common.utils.ThreadLocalUtil;
import com.whitrue.rical.common.utils.validate.ValidateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/7 1:50 PM
 */
@RestController
@RequestMapping("/job/")
public class JobController {

    @Resource
    private IJobBiz jobBiz;

    @PostMapping("add")
    public BaseResponse<Boolean> addJob(@RequestBody JobAddReq req){
        BaseResponse<Boolean> resp = new BaseResponse<>();
        ValidateUtil validate = new ValidateUtil()
                .object("JobAddReq", () -> req)
                .notNull("author", "scheduleType", "scheduleConf", "executorHandler")
                .build();
        if(!validate.isValid()){
            resp.setSuccess(false);
            resp.setError(validate.getError());
            return resp;
        }

        JobInfoDTO jobInfoDTO = JobAdapter.addReq2dto(req);
        String businessId = String.format("%s_addJob_%d", ThreadLocalUtil.getAppKey(), System.currentTimeMillis());
        jobInfoDTO.setBusinessId(businessId);
        Boolean result = jobBiz.addJob(jobInfoDTO);
        return resp.populateResponse(result);
    }

    @GetMapping("query")
    public BaseResponse<JobInfoResp> addJob(@RequestParam("jobId") Integer jobId){
        BaseResponse<JobInfoResp> resp = new BaseResponse<>();
        ValidateUtil validate = new ValidateUtil()
                .expression()
                .check("check jobId", ()->jobId!=null&&jobId>0)
                .build();
        if(!validate.isValid()){
            resp.setSuccess(false);
            resp.setError(validate.getError());
            return resp;
        }

        JobInfoDTO result = jobBiz.queryJob(jobId);
        return resp.populateResponse(JobAdapter.dto2resp(result));
    }
}
