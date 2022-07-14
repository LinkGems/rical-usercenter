package com.whitrue.rical.backend.biz.impl;

import com.whitrue.rical.backend.biz.IUserBiz;
import com.whitrue.rical.backend.domain.dto.UserBaseDTO;
import com.whitrue.rical.backend.service.IUserService;
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
