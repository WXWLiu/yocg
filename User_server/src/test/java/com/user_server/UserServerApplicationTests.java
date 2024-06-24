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
    public void TestfindAllUser() {
        List<User> user = userService.findUser();
        System.out.println(user);


    }

    /**
     * 测试通过电话号和密码进行查询
     */
//    public List<User> findUserBypwdandtp(User user);
    @Test
    public void TestfindUserBypwdandtp() {
        User user = new User();
        user.setUtelephone("18359551104");
        user.setUpassward("12345678");
        User user1 = userService.findUserBypwdandtp(user);
        System.out.println(user1);
    }

    /**
     * 插入用户
     *
     * @return
     */
    @Test
    public void testinsertUser() {
        User user = new User();
        user.setUname("王五");
        user.setUpassward("12345678");
        user.setUtelephone("18379121102");
        boolean i = userService.insertUser(user);
        if (i) {
            System.out.println("增加成功");
        } else {
            System.out.println("增加失败");
        }
    }

    /**
     * 测试通过用户名查询用户
     */
    @Test
    public void testfindUserByuname() {
        User user = new User();
        user.setUname("王五");
        List<User> userByuname = userService.findUserByuname(user);
        System.out.println(userByuname);
    }

    /**
     * 测试通过用户名查询用户
     */
    @Test
    public void testfindUserBytele() {
        User user = new User();
        user.setUtelephone("18359551104");
        List<User> userByuname = userService.findUserBytele(user);
        System.out.println(userByuname);
    }


    /**
     * 测试查询用户的关注数
     */
    @Test
    public void testgetfollowcount() {
        int i = userService.getfollowcount(17);
        System.out.println(i);
    }
    /**
     * 获取她粉丝的人数
     */
    @Test
    public void getfanscount(){
        int i = userService.getfanscount(17);
        System.out.println(i);
    }
}