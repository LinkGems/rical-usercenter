package com.wtrue.rical.usercenter.export.provider;

import com.wtrue.rical.common.adam.domain.BaseResponse;
import com.wtrue.rical.usercenter.export.pojo.UserDetailModel;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:50 PM
 */
public interface IUserProvider {

    BaseResponse<UserDetailModel> queryUser(Long userId);
}
