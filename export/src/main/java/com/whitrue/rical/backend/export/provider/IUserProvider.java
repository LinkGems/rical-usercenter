package com.whitrue.rical.backend.export.provider;

import com.whitrue.rical.backend.export.pojo.UserBaseModel;
import com.whitrue.rical.common.domain.BaseResponse;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:50 PM
 */
public interface IUserProvider {

    BaseResponse<UserBaseModel> queryUser(Long userId);
}
