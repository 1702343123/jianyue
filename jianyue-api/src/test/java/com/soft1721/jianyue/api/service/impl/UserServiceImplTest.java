package com.soft1721.jianyue.api.service.impl;
/**
 * Created by wj on 2019/4/1.
 */
import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.dto.UserDTO;
import com.soft1721.jianyue.api.service.UserService;
import com.soft1721.jianyue.api.util.StatusConst;
import com.soft1721.jianyue.api.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void getUserByMobile() {
        User user = userService.getUserByMobile("13988889999");
        System.out.println(user);
    }

    @Test
    public void getUserId(){
        User user=userService.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void updateUser(){
        User user=userService.getUserById(1);
        user.setAvatar("1.jpg");
        userService.updateUser(user);
    }

    @Test
    public void updateName(){
        User user=userService.getUserById(1);
        user.setNickname("HZT");
        userService.updateName(user);
    }

    @Test
    public void signIn() {
        UserDTO loginUser = new UserDTO();
        loginUser.setMobile("13951905171");
        String base64Pass = StringUtil.getBase64Encoder("111");
        loginUser.setPassword(base64Pass);
        int status = userService.signIn(loginUser);
        assertEquals(StatusConst.SUCCESS, status);
    }

    @Test
    public void signUp() {
        UserDTO userDTO = new UserDTO();
        userDTO.setMobile("13951901489");
        userDTO.setPassword("111");
        userService.signUp(userDTO);
    }

}