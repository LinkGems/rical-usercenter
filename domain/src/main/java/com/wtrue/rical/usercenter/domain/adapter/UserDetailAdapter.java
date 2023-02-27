package com.wtrue.rical.usercenter.domain.adapter;

import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;
import com.wtrue.rical.usercenter.domain.po.UserDetailPO;
import com.wtrue.rical.usercenter.domain.request.UserRegisterReq;
import com.wtrue.rical.usercenter.export.pojo.UserDetailModel;

/**
 * @description:
 * @author: meidanlong
 * @date: 2023/2/25 4:40 PM
 */
public class UserDetailAdapter {

    public static UserDetailDTO po2dto(UserDetailPO po) {
        if (po == null) {
            return null;
        }
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setUserId(po.getUserId());
        userDetailDTO.setBaseUserId(po.getBaseUserId());
        userDetailDTO.setUserName(po.getUserName());
        userDetailDTO.setPassword(po.getPassword());
        userDetailDTO.setSalt(po.getSalt());
        userDetailDTO.setMobile(po.getMobile());
        userDetailDTO.setEmail(po.getEmail());
        userDetailDTO.setWeixinId(po.getWeixinId());
        userDetailDTO.setAliId(po.getAliId());
        return userDetailDTO;
    }

    public static UserDetailPO dto2po(UserDetailDTO dto) {
        if (dto == null) {
            return null;
        }
        UserDetailPO userDetailPO = new UserDetailPO();
        userDetailPO.setUserId(dto.getUserId());
        userDetailPO.setBaseUserId(dto.getBaseUserId());
        userDetailPO.setUserName(dto.getUserName());
        userDetailPO.setPassword(dto.getPassword());
        userDetailPO.setSalt(dto.getSalt());
        userDetailPO.setMobile(dto.getMobile());
        userDetailPO.setEmail(dto.getEmail());
        userDetailPO.setWeixinId(dto.getWeixinId());
        userDetailPO.setAliId(dto.getAliId());
        return userDetailPO;
    }

    public static UserDetailModel dto2model(UserDetailDTO dto) {
        if (dto == null) {
            return null;
        }
        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setUserId(dto.getUserId());
        userDetailModel.setBaseUserId(dto.getBaseUserId());
        userDetailModel.setUserName(dto.getUserName());
        userDetailModel.setMobile(dto.getMobile());
        userDetailModel.setEmail(dto.getEmail());
        userDetailModel.setWeixinId(dto.getWeixinId());
        userDetailModel.setAliId(dto.getAliId());
        return userDetailModel;
    }

    public static UserDetailDTO registerReq2dto(UserRegisterReq req) {
        if (req == null) {
            return null;
        }
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setUserName(req.getUserName());
        userDetailDTO.setPassword(req.getPassword());
        userDetailDTO.setMobile(req.getMobile());
        userDetailDTO.setEmail(req.getEmail());
        userDetailDTO.setWeixinId(req.getWeixinId());
        userDetailDTO.setAliId(req.getAliId());
        return userDetailDTO;
    }
}
