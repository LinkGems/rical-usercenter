package com.wtrue.rical.backend.provider;

import com.wtrue.rical.backend.biz.IUserBiz;
import com.wtrue.rical.backend.domain.adapter.UserAdapter;
import com.wtrue.rical.backend.domain.dto.UserBaseDTO;
import com.wtrue.rical.backend.export.vo.UserBaseVO;
import com.wtrue.rical.backend.export.provider.IUserProvider;
import com.wtrue.rical.common.domain.BaseResponse;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/7/18 4:51 PM
 */
@Service(version = "${provider.wtrue.rical.backend.ITestProvider}")
public class UserProvider implements IUserProvider {

    @Resource
    private IUserBiz userBiz;

    @Override
    public BaseResponse<UserBaseVO> queryUser(Long userId) {
        BaseResponse<UserBaseVO> response = new BaseResponse<>();
        UserBaseDTO userBaseDTO = userBiz.queryUser(userId);
        UserBaseVO userBaseVO = UserAdapter.dto2vo(userBaseDTO);
        if(userBaseVO != null){
            response.setData(userBaseVO);
        }else{
            response.setSuccess(false);
        }
        return response;
    }
}
