package com.whitrue.rical.backend.domain.vo.resp;

import com.whitrue.rical.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/2/7 2:37 PM
 */
@Getter
@Setter
public class JobInfoResp extends BaseObject {

    private Integer jobId;
    /**
     * 任务描述（任务唯一标识）
     */
    private String businessId;
    /**
     * 负责人
     */
    private String author;
    /**
     * 调度类型 默认CRON
     */
    private String scheduleType;
    /**
     * 调度配置，值含义取决于调度类型 默认CRON表达式
     */
    private String scheduleConf;
    /**
     * GLUE类型 默认BEAN
     */
    private String glueType;
    /**
     * 调度过期策略
     */
    private String misfireStrategy;
    /**
     * 执行器路由策略
     */
    private String executorRouteStrategy;
    /**
     * 执行器，任务Handler名称
     */
    private String executorHandler;
    /**
     * 执行器，任务参数
     */
    private String executorParam;
    /**
     * 阻塞处理策略
     */
    private String executorBlockStrategy;
    /**
     * 任务执行超时时间，单位秒
     */
    private Integer executorTimeout;
    /**
     * 失败重试次数
     */
    private Integer executorFailRetryCount;
    /**
     * 调度状态：0-停止，1-运行
     */
    private Integer triggerStatus;
    /**
     * 上次调度时间
     */
    private Long triggerLastTime;
    /**
     * 下次调度时间
     */
    private Long triggerNextTime;
    /**
     * 子任务ID，多个逗号分隔。当本任务执行结束并且执行成功时，将会触发子任务ID所对应的任务的一次主动调度
     */
    private String childJobId;
}
