package com.user_server;

import com.user_server.entity.User;
import com.user_server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServerApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
    }
    @Test
    public void TestfindAllUser(){
        List<User> user = userService.findUser();
        System.out.println(user);
    }
}
