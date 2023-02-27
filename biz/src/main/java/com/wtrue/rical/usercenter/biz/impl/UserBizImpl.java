package com.wtrue.rical.usercenter.biz.impl;

import com.wtrue.rical.common.adam.enums.ErrorEnum;
import com.wtrue.rical.common.eve.utils.MD5Util;
import com.wtrue.rical.common.eve.utils.RSAUtil;
import com.wtrue.rical.common.eve.utils.StringUtil;
import com.wtrue.rical.usercenter.biz.IUserBiz;
import com.wtrue.rical.usercenter.common.util.TokenUtil;
import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;
import com.wtrue.rical.usercenter.domain.enums.BusinessErrorEnum;
import com.wtrue.rical.usercenter.domain.exception.BusinessException;
import com.wtrue.rical.usercenter.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 7:37 PM
 */
@Service
public class UserBizImpl implements IUserBiz {

    @Value("${rsa.private.key}")
    private String privateKey;

    @Resource
    private IUserDetailService userDetailService;

    @Override
    public UserDetailDTO queryUserDetailById(Long userId) {
        return userDetailService.queryUserDetailByUserId(userId);
    }

    @Override
    public String register(UserDetailDTO userDetailDTO){
        Long userId = addUserDetail(userDetailDTO);
        return new TokenUtil().generateToken(userId);
    }

    @Transactional
    public Long addUserDetail(UserDetailDTO userDetailDTO) {

        checkUserExists(userDetailDTO);

        String salt = String.valueOf(System.currentTimeMillis());
        String password = userDetailDTO.getPassword();
        String rawPassword;
        try{
            rawPassword = RSAUtil.decrypt(privateKey, password);
        }catch (Exception e){
            throw new BusinessException(BusinessErrorEnum.PASSWORD_ERROR, "密码解密失败！");
        }
        String md5Password = MD5Util.sign(rawPassword, salt, "UTF-8");
        userDetailDTO.setSalt(salt);
        userDetailDTO.setPassword(md5Password);
        Long userId = userDetailService.getNextUserId();
        userDetailDTO.setUserId(userId);
        userDetailService.addUserDetail(userDetailDTO);
        return userId;
    }

    public Boolean mobileExists(String mobile){
        if(StringUtil.isEmpty(mobile)){
            throw new BusinessException(ErrorEnum.PARAM_ERROR, "手机号为空");
        }
        UserDetailDTO userDetailDTO = userDetailService.queryUserDetailByMobile(mobile);
        return !ObjectUtils.isEmpty(userDetailDTO);
    }

    public Boolean userNameExists(String userName){
        if(StringUtil.isEmpty(userName)){
            throw new BusinessException(ErrorEnum.PARAM_ERROR, "用户名为空");
        }
        UserDetailDTO userDetailDTO = userDetailService.queryUserDetailByUserName(userName);
        return !ObjectUtils.isEmpty(userDetailDTO);
    }

    public Boolean emailExists(String email){
        if(StringUtil.isEmpty(email)){
            throw new BusinessException(ErrorEnum.PARAM_ERROR, "邮箱为空");
        }
        UserDetailDTO userDetailDTO = userDetailService.queryUserDetailByEmail(email);
        return !ObjectUtils.isEmpty(userDetailDTO);
    }

    private void checkUserExists(UserDetailDTO userDetailDTO){
        // 1、查询用户名是否已经注册
        String userName = userDetailDTO.getUserName();
        if(StringUtil.isNotEmpty(userName) && userNameExists(userName)){
            throw new BusinessException(ErrorEnum.PARAM_ERROR, "该手机号已经注册");
        }
        // 2、查询手机号是否已注册
        String mobile = userDetailDTO.getMobile();
        if(StringUtil.isNotEmpty(mobile) && mobileExists(mobile)){
            throw new BusinessException(ErrorEnum.PARAM_ERROR, "该手机号已经注册");
        }
        // 3、查询手机号是否已注册
        String email = userDetailDTO.getEmail();
        if(StringUtil.isNotEmpty(email) && emailExists(email)){
            throw new BusinessException(ErrorEnum.PARAM_ERROR, "该邮箱已经注册");
        }
    }
}
