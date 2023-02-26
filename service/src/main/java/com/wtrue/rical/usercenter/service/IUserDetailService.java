package com.wtrue.rical.usercenter.service;

import com.wtrue.rical.usercenter.domain.dto.UserBaseDTO;
import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 6:52 PM
 */
public interface IUserDetailService {

    UserDetailDTO queryUserDetailByUserId(Long userId);

    UserDetailDTO queryUserDetailByUserName(String userName);

    UserDetailDTO queryUserDetailByMobile(String mobile);

    UserDetailDTO queryUserDetailByEmail(String email);

    UserDetailDTO queryUserDetailByWeixinId(String weixinId);

    UserDetailDTO queryUserDetailByAliId(String aliId);

    UserDetailDTO queryUserDetail(UserDetailDTO userDetailDTO);

    void addUserDetail(UserDetailDTO userDetailDTO);

    Long getNextUserId();

}
