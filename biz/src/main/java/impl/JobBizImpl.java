package impl;

import com.alibaba.fastjson.JSON;
import com.wtrue.jobcenter.export.pojo.JobAddModel;
import com.wtrue.jobcenter.export.remote.IJobProvider;
import com.wtrue.rical.backend.biz.IJobBiz;
import com.wtrue.rical.common.domain.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/5 12:26 PM
 */
@Service
public class JobBizImpl implements IJobBiz {

    @Value("${dubbo.application.id}")
    private String appKey;
    @Resource
    private IJobProvider iJobProvider;

    @Override
    public Boolean addJob() {
        JobAddModel jobAddModel = new JobAddModel();
        jobAddModel.setBusinessId(appKey + "_" + System.currentTimeMillis());
        jobAddModel.setScheduleType("CRON");
        jobAddModel.setScheduleConf("0/10 * * * * ?");
        jobAddModel.setGlueType("BEAN");
        jobAddModel.setExecutorHandler("backendJobHandler");
        jobAddModel.setExecutorParam(JSON.toJSONString(appKey));
        BaseResponse<Integer> response = iJobProvider.addJob(jobAddModel);
        return response.isSuccess();
    }
}