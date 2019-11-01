package com.example.gmall.usermanage.service.impl;

import bean.UserAddress;
import bean.UserInfo;
import com.example.gmall.usermanage.mapper.UserAddressMapper;
import com.example.gmall.usermanage.mapper.UserInfoMapper;
import com.example.gmall.usermanage.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    //search all info
    @Override
    public List<UserInfo> getUserInfoList(UserInfo userInfoQuery) {
        List<UserInfo> userInfos = null;

        Example example = new Example(UserInfo.class);

        example.createCriteria().andLike("loginName", "%" + userInfoQuery.getLoginName() + "%");
        userInfos = userInfoMapper.selectByExample(example);
        return userInfos;

    }

    //single table search
    @Override
    public UserInfo getUserInfo(UserInfo userInfoQuery){
        UserInfo userInfo = null;

        userInfo = userInfoMapper.selectByPrimaryKey(userInfoQuery);

        return userInfo;
    }

    @Override
    public void deleteUserInfo(UserInfo userInfoQuery) {
        userInfoMapper.deleteByPrimaryKey(userInfoQuery);

    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);

        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {

        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName", "%" + userInfo + "%");

        userInfo.setName(null);
        userInfoMapper.updateByExampleSelective(userInfo, example);
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        List<UserAddress> addresslist = null;
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        addresslist = userAddressMapper.select(userAddress);
        return addresslist;
    }
}
