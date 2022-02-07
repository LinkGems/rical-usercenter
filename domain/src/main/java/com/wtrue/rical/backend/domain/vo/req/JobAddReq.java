package com.wtrue.rical.backend.domain.vo.req;

import com.wtrue.rical.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/7 2:05 PM
 */
@Getter
@Setter
public class JobAddReq extends BaseObject {

    private String author;
    private String scheduleType = "CRON";
    private String scheduleConf;
    private String glueType = "BEAN";
    private String misfireStrategy;
    private String executorRouteStrategy;
    private String executorHandler;
    private String executorParam;
    private String executorBlockStrategy;
    private Integer executorTimeout;
    private Integer executorFailRetryCount;

}
