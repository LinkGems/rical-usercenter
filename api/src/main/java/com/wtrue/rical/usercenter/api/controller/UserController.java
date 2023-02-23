package com.wtrue.rical.usercenter.api.controller;

import com.mysql.cj.util.StringUtils;
import com.wtrue.rical.common.eve.utils.MD5Util;
import com.wtrue.rical.common.eve.utils.RSAUtil;
import com.wtrue.rical.usercenter.common.util.TokenUtil;
import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;
import com.wtrue.rical.usercenter.domain.exception.BusinessException;
import com.wtrue.rical.usercenter.export.provider.IUserProvider;
import com.wtrue.rical.usercenter.export.pojo.UserBaseModel;
import com.wtrue.rical.common.adam.domain.BaseResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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

    @Transactional
    public void addUser(UserDetailDTO user) {
        String phone = user.getMobile();
        if(StringUtils.isNullOrEmpty(phone)){
//            throw new ConditionException("手机号不能为空！");
        }
//        User dbUser = this.getUserByPhone(phone);
//        if(dbUser != null){
//            throw new ConditionException("该手机号已经注册！");
//        }
//        Date now = new Date();
//        String salt = String.valueOf(now.getTime());
//        String password = user.getPassword();
//        String rawPassword;
//        try{
//            rawPassword = RSAUtil.decrypt(password);
//        }catch (Exception e){
//            throw new ConditionException("密码解密失败！");
//        }
//        String md5Password = MD5Util.sign(rawPassword, salt, "UTF-8");
//        user.setSalt(salt);
//        user.setPassword(md5Password);
//        user.setCreateTime(now);
//        userDao.addUser(user);
//        //添加用户信息
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(user.getId());
//        userInfo.setNick(UserConstant.DEFAULT_NICK);
//        userInfo.setBirth(UserConstant.DEFAULT_BIRTH);
//        userInfo.setGender(UserConstant.GENDER_MALE);
//        userInfo.setCreateTime(now);
//        userDao.addUserInfo(userInfo);
//        //添加用户默认权限角色
//        userAuthService.addUserDefaultRole(user.getId());
//        //同步用户信息数据到es
//        elasticSearchService.addUserInfo(userInfo);
    }
}
