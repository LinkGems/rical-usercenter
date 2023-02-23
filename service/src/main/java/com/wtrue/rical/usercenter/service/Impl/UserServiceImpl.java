package com.wtrue.rical.usercenter.service.Impl;

import com.wtrue.rical.usercenter.dao.mapper.UserBasePOMapper;
import com.wtrue.rical.usercenter.domain.adapter.UserAdapter;
import com.wtrue.rical.usercenter.domain.dto.UserBaseDTO;
import com.wtrue.rical.usercenter.domain.po.UserBasePO;
import com.wtrue.rical.usercenter.service.IUserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 7:38 PM
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserBasePOMapper userBasePOMapper;


    @Override
    public UserBaseDTO queryUser(Long userId) {
        // 自定义条件搜索对象 Example
        Example userBaseExample = new Example(UserBasePO.class);
        Example.Criteria criteria = userBaseExample.createCriteria();
        criteria.andEqualTo("userId", userId)
                .andEqualTo("deleted", 0);
        UserBasePO userBase = userBasePOMapper.selectOneByExample(userBaseExample);
        return UserAdapter.po2dto(userBase);
    }
}
