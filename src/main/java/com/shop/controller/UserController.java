package com.shop.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shop.service.UserService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    //登录验证账号密码
    // http://localhost:8080/user/login?username=admin&password=root123

    @RequestMapping(value = "/login")
    public String loginByPassword(String username,String password){
        User user = userService.login(username,password);
        if(user!=null){
            return "success";
        }else {
            return "error";
        }
    }
    //获取用户信息
    //http://localhost:8080/user/getUserInfo?username=admin
    @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.POST)
    User getUserInfo(@RequestBody String username){
        User user = userService.getUserInfo(username);
        return user;
    }

    //修改密码
    //http://localhost:8080/user/updatePassword?username=admin&oldPassword=root123&newPassword=root1234
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    String updatePasswordByUsername(@RequestBody String username,String oldPassword,String newPassword){
        User user = userService.login(username,oldPassword);
        int result = 0;
        if(user!=null){
            result = userService.updatePassword(username,newPassword);
        }
        if(result>=1){
            return "success";
        }else {
            return "error";
        }
    }
}
