package com.wtrue.rical.backend.service.Impl;

import com.wtrue.rical.backend.dao.mapper.user.UserBaseMapper;
import com.wtrue.rical.backend.dao.po.user.UserBase;
import com.wtrue.rical.backend.domain.adapter.UserAdapter;
import com.wtrue.rical.backend.domain.dto.UserBaseDTO;
import com.wtrue.rical.backend.service.IUserService;
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
    private UserBaseMapper userBaseMapper;


    @Override
    public UserBaseDTO queryUser(Long userId) {
        // 自定义条件搜索对象 Example
        Example userBaseExample = new Example(UserBase.class);
        Example.Criteria criteria = userBaseExample.createCriteria();
        criteria.andEqualTo("userId", userId)
                .andEqualTo("deleted", 0);
        UserBase userBase = userBaseMapper.selectOneByExample(userBaseExample);
        return UserAdapter.po2dto(userBase);
    }
}
