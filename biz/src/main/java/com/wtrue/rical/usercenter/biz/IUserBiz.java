package com.wtrue.rical.usercenter.biz;

import com.wtrue.rical.usercenter.domain.dto.UserBaseDTO;
import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 7:36 PM
 */
public interface IUserBiz {

    UserDetailDTO queryUserDetailById(Long userId);

    Long addUserDetail(UserDetailDTO user);

    String register(UserDetailDTO userDetailDTO);
}
