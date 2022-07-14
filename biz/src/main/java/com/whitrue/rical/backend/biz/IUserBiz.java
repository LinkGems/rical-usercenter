package com.whitrue.rical.backend.biz;

import com.whitrue.rical.backend.domain.dto.UserBaseDTO;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 7:36 PM
 */
public interface IUserBiz {

    UserBaseDTO queryUser(Long userId);
}
