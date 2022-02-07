package com.wtrue.rical.backend.biz;

import com.alibaba.fastjson.JSON;
import com.wtrue.jobcenter.export.pojo.JobAddModel;
import com.wtrue.rical.backend.App;
import com.wtrue.rical.backend.domain.dto.JobInfoDTO;
import com.wtrue.rical.common.domain.ThreadLocalData;
import com.wtrue.rical.common.utils.ThreadLocalUtil;
import org.apache.dubbo.rpc.RpcContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/5 4:13 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class JobBizTest {

    @Value("${dubbo.application.id}")
    private String appKey;

    @Autowired
    private IJobBiz jobBiz;

    @Test
    public void addJob() {
//        RpcContext.getContext().setAttachment("appKey", appKey);
        JobInfoDTO jobInfoDTO = new JobInfoDTO();
        jobInfoDTO.setBusinessId(appKey + "_" + System.currentTimeMillis());
        jobInfoDTO.setAuthor(appKey);
        jobInfoDTO.setScheduleType("CRON");
        jobInfoDTO.setScheduleConf("0/10 * * * * ?");
        jobInfoDTO.setGlueType("BEAN");
        jobInfoDTO.setExecutorHandler("backendJobHandler");
        jobInfoDTO.setExecutorParam(JSON.toJSONString(appKey));
        Boolean result = jobBiz.addJob(jobInfoDTO);
        Boolean result1 = jobBiz.addJob(jobInfoDTO);
        Assert.assertTrue(result);
        Assert.assertTrue(result1);
    }

    public static void main(String[] args) {
        String appKey = "rical-backend-provider";
        JobAddModel jobAddModel = new JobAddModel();
        jobAddModel.setBusinessId(appKey + "_" + System.currentTimeMillis());
        jobAddModel.setAuthor(appKey);
        jobAddModel.setScheduleType("CRON");
        jobAddModel.setScheduleConf("0/10 * * * * ?");
        jobAddModel.setGlueType("BEAN");
        jobAddModel.setExecutorHandler("backendJobHandler");
        jobAddModel.setExecutorParam(JSON.toJSONString(appKey));
        System.out.println(JSON.toJSONString(jobAddModel));
    }
}
