package com.shop.service;

import com.shop.entity.User;
import com.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password){
        return userMapper.login(username,password);
    }
    public User getUserInfo(String username){
        return userMapper.getUserInfo(username);
    }
    public int updatePassword(String username,String newPassword){
        return userMapper.updatePassword(username,newPassword);
    }
}
