package com.happy.go;

import com.happy.go.entity.User;
import com.happy.go.mapper.UserMapper;
import com.happy.go.service.IUserService;
import com.happy.go.service.impl.UserSServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoApplicationTests {


    @Autowired
    private UserSServiceImpl userSService;

    @Autowired
    private IUserService iUserService;


    @Test
    void contextLoads() {
        System.out.println(1%2);
    }

    @Test
    void select() {
        User user = new User();
        user.setId(46);
        iUserService.getUser(user);
        System.out.println(1%2);
        System.out.println(user);
    }



}
