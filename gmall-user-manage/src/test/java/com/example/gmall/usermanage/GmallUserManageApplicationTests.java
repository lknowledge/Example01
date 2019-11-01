package com.example.gmall.usermanage;

import bean.UserAddress;
import com.example.gmall.usermanage.service.UserManagerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class GmallUserManageApplicationTests {

    @Autowired
    UserManagerService userManagerService;

    @Test
    public void showAddressList(){
        List<UserAddress> userAddressList = userManagerService.getUserAddressList("1000");
        for (UserAddress userAddress:userAddressList){
            System.out.println("userAddress" + userAddress);
        }
    }


    @Test
    void contextLoads() {
    }

}
