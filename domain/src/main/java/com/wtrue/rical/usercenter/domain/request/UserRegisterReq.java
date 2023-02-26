package com.wtrue.rical.usercenter.domain.request;

import com.wtrue.rical.common.adam.domain.BaseObject;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: meidanlong
 * @date: 2023/2/25 8:28 PM
 */
@Data
public class UserRegisterReq extends BaseObject {

    /**
     * 用户登录用户名
     */
    private String userName;

    /**
     * 用户登录密码;密文
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信ID
     */
    private String weixinId;

    /**
     * 阿里ID
     */
    private String aliId;
}
