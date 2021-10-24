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
import java.util.HashMap;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    //登录验证账号密码
    // http://localhost:8080/user/login?username=admin&password=root123
    @PassToken
    @RequestMapping(value = "/login")
    public Object  loginByPassword(HttpServletRequest request, HttpServletResponse response){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        JSONObject jsonObject = new JSONObject();
        User user = userService.login(username,password);
        if(user!=null){
            session.setAttribute("username ",username);
            String token = tokenService.getToken(user);
            jsonObject.put("message", "login success!");
            jsonObject.put("token", token);
            jsonObject.put("username ",username);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return jsonObject;
        } else{
//            jsonObject.put("message", "code error!");
            jsonObject.put("message", "login error!");
            return jsonObject;
        }
    }
    //获取用户信息
    //http://localhost:8080/user/getUserInfo?username=admin
    @RequestMapping(value = "/getUserInfo")
    User getUserInfo( String username){
        User user = userService.getUserInfo(username);
        return user;
    }

    //修改密码
    //http://localhost:8080/user/updatePassword?username=admin&oldPassword=root123&newPassword=root1234
    @RequestMapping(value = "/updatePassword")
    String updatePasswordByUsername( String username,String oldPassword,String newPassword){
        User user = userService.login(username,oldPassword);
        int result = 0;
        if(user!=null){
            result = userService.updatePassword(username,newPassword);
        }
        if(result>=1){
            return newPassword;
        }else {
            return oldPassword;
        }
    }

    /*测试token  不登录没有token*/
    @UserLoginToken
    @RequestMapping("/getMessage")
    public String getMessage(){

        return "你已通过验证";
    }
}
