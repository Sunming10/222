package com.shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.annotation.PassToken;
import com.shop.annotation.UserLoginToken;
import com.shop.entity.User;
import com.shop.token.TokenService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shop.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private String message = "error";

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    //登录验证账号密码
    // http://localhost:8080/user/login?username=admin&password=root123
    @RequestMapping(value = "/login")
    public Object loginByPassword(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        JSONObject jsonObject = new JSONObject();
        User user = userService.login(username,password);
        if(user!=null){
            message = "success";
            String token = tokenService.getToken(user);
            jsonObject.put("token", token);
            jsonObject.put("username ",username);
        } else{
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }
    //获取用户信息
    //http://localhost:8080/user/getUserInfo?username=admin
    @RequestMapping(value = "/getUserInfo")
    public Object getUserInfo(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        JSONObject jsonObject = new JSONObject();
        User user = userService.getUserInfo(username);
        jsonObject.put("user",user);
        return jsonObject;
    }

    //修改密码
    //http://localhost:8080/user/updatePassword?username=admin&oldPassword=root123&newPassword=root1234
    @RequestMapping(value = "/updatePassword")
    public Object updatePasswordByUsername(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        JSONObject jsonObject = new JSONObject();
        User user = userService.login(username,oldPassword);
        int result = 0;
        if(user!=null){
            result = userService.updatePassword(username,newPassword);
        }
        if(result>=1){
            message = "success";
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    /*测试token  不登录没有token*/
    @UserLoginToken
    @RequestMapping("/getMessage")
    public Object getMessage(){
        message = "success";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message",message);
        return jsonObject;
    }
}
