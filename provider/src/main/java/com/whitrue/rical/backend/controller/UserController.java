package com.whitrue.rical.backend.controller;

import com.whitrue.rical.backend.export.provider.IUserProvider;
import com.whitrue.rical.backend.export.pojo.UserBaseModel;
import com.whitrue.rical.common.domain.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 5:04 PM
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    private IUserProvider userProvider;

    @GetMapping("query")
    public BaseResponse<UserBaseModel> queryUser(Long userId){
        return userProvider.queryUser(userId);
    }
}
