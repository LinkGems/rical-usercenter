package com.wtrue.rical.backend.domain.adapter;

import com.wtrue.rical.backend.dao.po.UserBase;
import com.wtrue.rical.backend.domain.dto.UserBaseDTO;
import com.wtrue.rical.backend.export.vo.UserBaseVO;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 7:11 PM
 */
public class UserAdapter {

    public static UserBaseDTO po2dto(UserBase userBase) {
        if (userBase == null) {
            return null;
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setUserId(userBase.getUserId());
        userBaseDTO.setIdType(userBase.getIdType());
        userBaseDTO.setIdNum(userBase.getIdNum());
        return userBaseDTO;
    }

    public static UserBaseDTO vo2dto(UserBaseVO userBaseVO) {
        if (userBaseVO == null) {
            return null;
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setUserId(userBaseVO.getUserId());
        userBaseDTO.setIdType(userBaseVO.getIdType());
        userBaseDTO.setIdNum(userBaseVO.getIdNum());
        return userBaseDTO;
    }

    public static UserBaseVO dto2vo(UserBaseDTO userBaseDTO) {
        if (userBaseDTO == null) {
            return null;
        }
        UserBaseVO userBaseVO = new UserBaseVO();
        userBaseVO.setUserId(userBaseDTO.getUserId());
        userBaseVO.setIdType(userBaseDTO.getIdType());
        userBaseVO.setIdNum(userBaseDTO.getIdNum());
        return userBaseVO;
    }
}
