package com.wtrue.rical.usercenter.domain.dto;

import com.wtrue.rical.common.adam.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;


/**
 * @description:用户实名信息表
 * @author: meidanlong
 * @date: 2021/11/28 7:11 PM
 */
@Getter
@Setter
public class UserBaseDTO extends BaseObject {


    /**
     * 用户唯一ID;用户真实唯一ID
     */
    private Long baseUserId;

    /**
     * 用户名称;用户真实名称（姓名）
     */
    private String baseUserName;

    /**
     * 用户性别;用户性别
     */
    private Byte sex;

    /**
     * 身份类型;1:身份证，2:护照
     */
    private Byte idType;

    /**
     * 证件号;用户身份证号
     */
    private String idNum;

}