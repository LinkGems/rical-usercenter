package com.wtrue.rical.usercenter.api.controller;

import com.wtrue.rical.common.eve.utils.RSAUtil;
import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;
import com.wtrue.rical.usercenter.export.provider.IUserProvider;
import com.wtrue.rical.usercenter.export.pojo.UserBaseModel;
import com.wtrue.rical.common.adam.domain.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 用户Http接口
 * @author: meidanlong
 * @date: 2021/7/18 5:04 PM
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private IUserProvider userProvider;

    @GetMapping("publicKey")
    public BaseResponse<String> getPublicKey(){
        String pk = RSAUtil.getPublicKeyStr();
        return BaseResponse.success(pk);
    }

    @GetMapping("query")
    public BaseResponse<UserBaseModel> queryUserById(Long userId){
        return null;
    }
}
