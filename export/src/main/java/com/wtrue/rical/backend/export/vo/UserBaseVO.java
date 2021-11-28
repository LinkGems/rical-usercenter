package com.wtrue.rical.backend.export.vo;

import com.wtrue.rical.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 6:49 PM
 */
@Getter
@Setter
public class UserBaseVO extends BaseObject {

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
