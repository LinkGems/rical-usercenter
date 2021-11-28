package com.wtrue.rical.backend.domain.dto;

import com.wtrue.rical.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 7:11 PM
 */
@Getter
@Setter
public class UserBaseDTO extends BaseObject {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * ID类型，1：身份证
     */
    private Byte idType;

    /**
     * 身份证号
     */
    private String idNum;
}
