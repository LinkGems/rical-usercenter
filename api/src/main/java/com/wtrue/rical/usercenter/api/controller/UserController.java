package com.wtrue.rical.usercenter.api.controller;

import com.mysql.cj.util.StringUtils;
import com.wtrue.rical.common.eve.utils.MD5Util;
import com.wtrue.rical.common.eve.utils.RSAUtil;
import com.wtrue.rical.usercenter.biz.IUserBiz;
import com.wtrue.rical.usercenter.common.util.TokenUtil;
import com.wtrue.rical.usercenter.domain.adapter.UserDetailAdapter;
import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;
import com.wtrue.rical.usercenter.domain.exception.BusinessException;
import com.wtrue.rical.usercenter.domain.request.UserRegisterReq;
import com.wtrue.rical.usercenter.export.pojo.UserDetailModel;
import com.wtrue.rical.usercenter.export.provider.IUserProvider;
import com.wtrue.rical.usercenter.export.pojo.UserBaseModel;
import com.wtrue.rical.common.adam.domain.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${rsa.public.key}")
    public String publicKey;

    @Resource
    private IUserProvider userProvider;
    @Resource
    private IUserBiz userBiz;

    @GetMapping("publicKey")
    public BaseResponse<String> getPublicKey(){
        return BaseResponse.success(publicKey);
    }

    @GetMapping("query")
    public BaseResponse<UserDetailModel> queryUserById(@NotNull(message = "userId不能为空") Long userId){
        return userProvider.queryUser(userId);
    }


    @PostMapping("register")
    public BaseResponse<String> registerUser(UserRegisterReq request){
        // 校验
        UserDetailDTO userDetailDTO = UserDetailAdapter.registerReq2dto(request);
        String token = userBiz.register(userDetailDTO);
        return BaseResponse.success(token);
    }

    public Long getCurrentUserId() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader("token");
        Long userId = new TokenUtil().verifyToken(token);
        if(userId < 0) {
            throw new BusinessException("非法用户");
        }
//        this.verifyRefreshToken(userId);
        return userId;
    }

}
