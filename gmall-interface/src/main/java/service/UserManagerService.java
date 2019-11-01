package com.example.gmall.usermanage.service;

import bean.UserAddress;
import bean.UserInfo;

import java.util.List;

public interface UserManagerService  {

    public List<UserInfo> getUserInfoList(UserInfo userInfoQuery);

    public UserInfo getUserInfo(UserInfo userInfoQuery);

    public void deleteUserInfo(UserInfo userInfoQuery);

    public void addUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);

    List<UserAddress> getUserAddressList(String userId);

}
