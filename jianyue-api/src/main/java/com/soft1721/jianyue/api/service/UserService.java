package com.soft1721.jianyue.api.service;

/**
 * Created by wj on 2019/4/1.
 */
import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.dto.UserDTO;

public interface UserService {

    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    User getUserByMobile(String mobile);

    /**
    * 根据id获取用户数据
     *
    * */
    User getUserById(Integer id);

    /**
     * 更改头像
     * */
    void updateUser(User user);

    /**
     * 更改昵称
     * */
    void updateName(User user);

    /**
     * 登录方法
     *
     * @param userDTO
     * @return boolean
     */
    int signIn(UserDTO userDTO);

    /**
     * 用户注册方法
     * @param userDTO
     * @return int
     */
    void signUp(UserDTO userDTO);
}
