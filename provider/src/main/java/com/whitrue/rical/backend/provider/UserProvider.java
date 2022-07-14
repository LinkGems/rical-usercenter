package com.whitrue.rical.backend.provider;

import com.whitrue.rical.backend.biz.IUserBiz;
import com.whitrue.rical.backend.domain.adapter.UserAdapter;
import com.whitrue.rical.backend.domain.dto.UserBaseDTO;
import com.whitrue.rical.backend.export.pojo.UserBaseModel;
import com.whitrue.rical.backend.export.provider.IUserProvider;
import com.whitrue.rical.common.domain.BaseResponse;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:51 PM
 */
@Service(version = "${provider.whitrue.rical.backend.ITestProvider}")
public class UserProvider implements IUserProvider {

    @Resource
    private IUserBiz userBiz;

    @Override
    public BaseResponse<UserBaseModel> queryUser(Long userId) {
        BaseResponse<UserBaseModel> response = new BaseResponse<>();
        UserBaseDTO userBaseDTO = userBiz.queryUser(userId);
        UserBaseModel userBaseModel = UserAdapter.dto2mo(userBaseDTO);
        if(userBaseModel != null){
            response.setData(userBaseModel);
        }else{
            response.setSuccess(false);
        }
        return response;
    }
}
