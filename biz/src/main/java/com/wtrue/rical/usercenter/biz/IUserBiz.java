package com.wtrue.rical.usercenter.biz;

import com.wtrue.rical.usercenter.domain.dto.UserBaseDTO;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 7:36 PM
 */
public interface IUserBiz {

    UserBaseDTO queryUser(Long userId);
}
