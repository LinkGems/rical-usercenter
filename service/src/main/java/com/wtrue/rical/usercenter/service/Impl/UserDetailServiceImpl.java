package com.wtrue.rical.usercenter.service.Impl;

import com.wtrue.rical.common.adam.enums.ErrorEnum;
import com.wtrue.rical.usercenter.dao.mapper.UserDetailPOMapper;
import com.wtrue.rical.usercenter.domain.adapter.UserDetailAdapter;
import com.wtrue.rical.usercenter.domain.dto.UserDetailDTO;
import com.wtrue.rical.usercenter.domain.enums.BusinessErrorEnum;
import com.wtrue.rical.usercenter.domain.exception.BusinessException;
import com.wtrue.rical.usercenter.domain.po.UserDetailPO;
import com.wtrue.rical.usercenter.service.IUserDetailService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/11/28 7:38 PM
 */
@Service
public class UserDetailServiceImpl implements IUserDetailService {

    @Resource
    private UserDetailPOMapper userDetailPOMapper;


    @Override
    public UserDetailDTO queryUserDetailByUserId(Long userId) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setUserId(userId);
        return queryUserDetail(userDetailDTO);
    }

    @Override
    public UserDetailDTO queryUserDetailByUserName(String userName) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setUserName(userName);
        return queryUserDetail(userDetailDTO);
    }

    @Override
    public UserDetailDTO queryUserDetailByMobile(String mobile) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setMobile(mobile);
        return queryUserDetail(userDetailDTO);
    }

    @Override
    public UserDetailDTO queryUserDetailByEmail(String email) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setEmail(email);
        return queryUserDetail(userDetailDTO);
    }

    @Override
    public UserDetailDTO queryUserDetailByWeixinId(String weixinId) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setWeixinId(weixinId);
        return queryUserDetail(userDetailDTO);
    }

    @Override
    public UserDetailDTO queryUserDetailByAliId(String aliId) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setAliId(aliId);
        return queryUserDetail(userDetailDTO);
    }

    public UserDetailDTO queryUserDetail(UserDetailDTO userDetailDTO) {
        // 自定义条件搜索对象 Example
        Example userDetailExample = new Example(UserDetailPO.class);
        Example.Criteria criteria = userDetailExample.createCriteria();
        if(!ObjectUtils.isEmpty(userDetailDTO.getUserId())){
            criteria.andEqualTo("USER_ID", userDetailDTO.getUserId());
        }
        if(!ObjectUtils.isEmpty(userDetailDTO.getUserName())){
            criteria.andEqualTo("USER_NAME", userDetailDTO.getUserName());
        }
        if(!ObjectUtils.isEmpty(userDetailDTO.getMobile())){
            criteria.andEqualTo("MOBILE", userDetailDTO.getMobile());
        }
        if(!ObjectUtils.isEmpty(userDetailDTO.getEmail())){
            criteria.andEqualTo("EMAIL", userDetailDTO.getEmail());
        }
        if(!ObjectUtils.isEmpty(userDetailDTO.getWeixinId())){
            criteria.andEqualTo("WEIXIN_ID", userDetailDTO.getWeixinId());
        }
        if(!ObjectUtils.isEmpty(userDetailDTO.getAliId())){
            criteria.andEqualTo("ALI_ID", userDetailDTO.getAliId());
        }
        UserDetailPO userDetailPO = selectExists(userDetailExample);
        return UserDetailAdapter.po2dto(userDetailPO);
    }

    @Override
    public void addUserDetail(UserDetailDTO userDetailDTO) {
        if(ObjectUtils.isEmpty(userDetailDTO)){
            throw new BusinessException(ErrorEnum.XXX, "保存用户信息为空");
        }
        UserDetailPO userDetailPO = UserDetailAdapter.dto2po(userDetailDTO);
        userDetailPOMapper.insertSelective(userDetailPO);
    }

    public Long getNextUserId(){
        // TODO: 2023/2/25 生成用户id今后会使用分布式id替换
        Example example = new Example(UserDetailPO.class);
        example.orderBy("user_id");
        List<UserDetailPO> userDetailPOS = userDetailPOMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userDetailPOS)){
            return 1L;
        }else{
            UserDetailPO userDetailPO = userDetailPOS.stream().findFirst().orElse(null);
            if(userDetailPO == null || userDetailPO.getUserId() == null){
                throw new BusinessException(ErrorEnum.XXX, "获取最大用户ID失败");
            }else{
                return userDetailPO.getUserId() + 1L;
            }
        }
    }


    private UserDetailPO selectExists(Example userDetailExample){
        Example.Criteria criteria = userDetailExample.createCriteria();
        criteria.andEqualTo("deleted", 0);
        userDetailExample.and(criteria);
        return userDetailPOMapper.selectOneByExample(userDetailExample);
    }
}
