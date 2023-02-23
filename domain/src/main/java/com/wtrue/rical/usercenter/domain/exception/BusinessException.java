package com.wtrue.rical.usercenter.domain.exception;

import com.wtrue.rical.common.adam.domain.BaseException;
import com.wtrue.rical.common.adam.enums.ErrorEnum;
import com.wtrue.rical.usercenter.domain.enums.BusinessErrorEnum;

/**
 * @description:
 * @author: meidanlong
 * @date: 2023/2/23 10:26
 */
public class BusinessException extends BaseException {

    public BusinessException(String error, String message) {
        super(error, message);
    }

    public BusinessException(String message) {
        super(ErrorEnum.XXX, message);
    }

    public BusinessException(BusinessErrorEnum error) {
        super(error.getCode(), error.getMessage());
    }
}
