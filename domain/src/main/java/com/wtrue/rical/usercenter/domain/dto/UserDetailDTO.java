package com.wtrue.rical.usercenter.domain.dto;

import com.wtrue.rical.common.adam.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

/**
 * @description:
 * @author: meidanlong
 * @date: 2023/2/22 16:59
 */
@Getter
@Setter
public class UserDetailDTO extends BaseObject {

    /**
     * 用户详情ID
     */
    private Long userId;

    /**
     * 用户唯一ID
     */
    private Long baseUserId;

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
