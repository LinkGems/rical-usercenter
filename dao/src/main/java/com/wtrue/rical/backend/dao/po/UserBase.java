package com.wtrue.rical.backend.dao.po;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "USER_BASE")
public class UserBase {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * ID类型，1：身份证
     */
    @Column(name = "ID_TYPE")
    private Byte idType;

    /**
     * 身份证号
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