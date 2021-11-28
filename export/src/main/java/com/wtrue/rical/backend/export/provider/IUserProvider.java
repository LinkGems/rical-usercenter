package com.wtrue.rical.backend.export.provider;

import com.wtrue.rical.backend.export.vo.UserBaseVO;
import com.wtrue.rical.common.domain.BaseResponse;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:50 PM
 */
public interface IUserProvider {

    BaseResponse<UserBaseVO> queryUser(Long userId);
}
