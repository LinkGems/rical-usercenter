package com.wtrue.rical.usercenter.api.controller;

import com.mysql.cj.util.StringUtils;
import com.wtrue.rical.common.eve.utils.MD5Util;
import com.wtrue.rical.common.eve.utils.RSAUtil;
import com.wtrue.rical.usercenter.common.util.TokenUtil;
import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;
import com.wtrue.rical.usercenter.domain.exception.BusinessException;
import com.wtrue.rical.usercenter.domain.request.UserRegisterReq;
import com.wtrue.rical.usercenter.export.pojo.UserDetailModel;
import com.wtrue.rical.usercenter.export.provider.IUserProvider;
import com.wtrue.rical.usercenter.export.pojo.UserBaseModel;
import com.wtrue.rical.common.adam.domain.BaseResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description: 用户Http接口
 * @author: meidanlong
 * @date: 2021/7/18 5:04 PM
 */
@Validated
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
    public BaseResponse<UserDetailModel> queryUserById(@NotNull(message = "userId不能为空") Long userId){
        return userProvider.queryUser(userId);
    }


    @PostMapping("register")
    public BaseResponse<String> registerUser(UserRegisterReq request){
        // 校验

        return null;
    }

    public Long getCurrentUserId() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader("token");
        Long userId = TokenUtil.verifyToken(token);
        if(userId < 0) {
            throw new BusinessException("非法用户");
        }
//        this.verifyRefreshToken(userId);
        return userId;
    }

}
