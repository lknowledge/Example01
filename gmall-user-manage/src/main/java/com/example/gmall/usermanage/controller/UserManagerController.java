package com.example.gmall.usermanage.controller;


import bean.UserInfo;
import com.example.gmall.usermanage.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManagerController {

    @Autowired
    UserManagerService userManagerService;

    @RequestMapping("/users")
    public ResponseEntity<List<UserInfo>> getUserList(UserInfo userInfo){
        List<UserInfo> userInfoList = userManagerService.getUserInfoList(userInfo);

        return ResponseEntity.ok().body(userInfoList);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> add(UserInfo userInfo){
        userManagerService.addUserInfo(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(UserInfo userInfo){
        userManagerService.updateUserInfo(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(UserInfo userInfo){
        userManagerService.deleteUserInfo(userInfo);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<UserInfo> getUserInfo(UserInfo userInfoQuery){
        UserInfo userInfo = userManagerService.getUserInfo(userInfoQuery);
        return ResponseEntity.ok().body(userInfo);
    }





}
