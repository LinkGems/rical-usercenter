package com.wtrue.rical.usercenter.provider;

import com.wtrue.rical.usercenter.biz.IUserBiz;
import com.wtrue.rical.usercenter.domain.adapter.UserBaseAdapter;
import com.wtrue.rical.usercenter.domain.adapter.UserDetailAdapter;
import com.wtrue.rical.usercenter.domain.dto.UserBaseDTO;
import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;
import com.wtrue.rical.usercenter.export.pojo.UserBaseModel;
import com.wtrue.rical.usercenter.export.pojo.UserDetailModel;
import com.wtrue.rical.usercenter.export.provider.IUserProvider;
import com.wtrue.rical.common.adam.domain.BaseResponse;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:51 PM
 */
@Service(version = "${provider.wtrue.rical.usercenter.ITestProvider}")
public class UserProvider implements IUserProvider {

    @Resource
    private IUserBiz userBiz;

    @Override
    public BaseResponse<UserDetailModel> queryUser(Long userId) {
        UserDetailDTO userDetailDTO = userBiz.queryUserDetailById(userId);
        UserDetailModel userDetailModel = UserDetailAdapter.dto2model(userDetailDTO);
        if(userDetailModel != null){
            return BaseResponse.success(userDetailModel);
        }else{
            return BaseResponse.failure();
        }
    }
}
