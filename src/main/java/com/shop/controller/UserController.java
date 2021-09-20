package com.shop.controller;

import com.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shop.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //登录验证账号密码
    // http://localhost:8080/user/login?username=admin&password=root123
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String loginByPassword(String username, String password){
        User user = userService.login(username,password);
        if(user!=null){
            return "success";
        }else {
            return "error";
        }
    }
    //获取用户信息
    //http://localhost:8080/user/getUserInfo?username=admin
    @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.GET)
    User getUserInfo(String username){
        User user = userService.getUserInfo(username);
        return user;
    }

    //修改密码
    //http://localhost:8080/user/updatePassword?username=admin&oldPassword=root123&newPassword=root1234
    @RequestMapping(value = "/updatePassword",method = RequestMethod.GET)
    String updatePasswordByUsername(String username,String oldPassword,String newPassword){
        User user = userService.login(username,oldPassword);
        int result = 0;
        if(user!=null){
            result = userService.updatePassword(username,newPassword);
        }
        if(result>=1){
            return "sucess";
        }else {
            return "fail";
        }
    }
}
