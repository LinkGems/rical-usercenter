package com.wtrue.rical.usercenter.export.pojo;

import com.wtrue.rical.common.adam.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 6:49 PM
 */
@Getter
@Setter
public class UserDetailModel extends BaseObject {

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
