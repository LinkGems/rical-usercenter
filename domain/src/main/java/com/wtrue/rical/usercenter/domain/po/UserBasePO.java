package com.wtrue.rical.usercenter.domain.po;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "user_base")
public class UserBasePO {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户唯一ID;用户真实唯一ID
     */
    @Column(name = "BASE_USER_ID")
    private Long baseUserId;

    /**
     * 用户名称;用户真实名称（姓名）
     */
    @Column(name = "BASE_USER_NAME")
    private String baseUserName;

    /**
     * 用户性别;用户性别
     */
    @Column(name = "SEX")
    private Byte sex;

    /**
     * 身份类型;1:身份证，2:护照
     */
    @Column(name = "ID_TYPE")
    private Byte idType;

    /**
     * 证件号;用户身份证号
     */
    @Column(name = "ID_NUM")
    private String idNum;

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