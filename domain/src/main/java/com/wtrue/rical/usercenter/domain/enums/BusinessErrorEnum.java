package com.wtrue.rical.usercenter.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 业务异常枚举
 * @author: meidanlong
 * @date: 2023/1/11 11:24
 */
@AllArgsConstructor
@Getter
public enum BusinessErrorEnum {

    // 31** 业务异常
    TOKEN_ERROR("3110", "TOKEN异常"),
    TOKEN_EXPIRED("3111", "TOKEN过期"),
    ;

    /**
     * 错误编码
     */
    private String code;

    /**
     * 错误描述
     */
    private String message;
}
