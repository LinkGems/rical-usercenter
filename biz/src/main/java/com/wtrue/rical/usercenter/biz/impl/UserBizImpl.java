package com.wtrue.rical.usercenter.biz.impl;

import com.wtrue.rical.usercenter.biz.IUserBiz;
import com.wtrue.rical.usercenter.domain.dto.UserBaseDTO;
import com.wtrue.rical.usercenter.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 7:37 PM
 */
@Service
public class UserBizImpl implements IUserBiz {

    @Resource
    private IUserService userService;

    @Override
    public UserBaseDTO queryUser(Long userId) {
        return userService.queryUser(userId);
    }
}
