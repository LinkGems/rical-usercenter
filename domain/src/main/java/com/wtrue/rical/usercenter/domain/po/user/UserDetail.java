package com.wtrue.rical.usercenter.domain.po.user;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "user_detail")
public class UserDetail {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * 用户详情ID
     */
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 用户唯一ID
     */
    @Column(name = "BASE_USER_ID")
    private Long baseUserId;

    /**
     * 用户登录用户名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 用户登录密码;密文
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 手机号
     */
    @Column(name = "MOBILE")
    private String mobile;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 微信ID
     */
    @Column(name = "WEIXIN_ID")
    private String weixinId;

    /**
     * 阿里ID
     */
    @Column(name = "ALI_ID")
    private String aliId;

    /**
     * 是否删除
     */
    @Column(name = "DELETED")
    private Byte deleted;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;
}