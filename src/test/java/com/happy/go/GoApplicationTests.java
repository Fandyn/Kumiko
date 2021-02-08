package com.happy.go;

import com.happy.go.mapper.UserMapper;
import com.happy.go.service.impl.UserSServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoApplicationTests {


    @Autowired
    private UserSServiceImpl userSService;

    @Test
    void contextLoads() {
        System.out.println(1%2);
    }

}
