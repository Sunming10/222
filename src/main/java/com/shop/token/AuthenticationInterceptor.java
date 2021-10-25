package com.shop.token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.annotation.PassToken;
import com.shop.annotation.UserLoginToken;
import com.shop.service.UserService;
import com.shop.entity.User;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/16 - 18:47
 * @description ：拦截器去获取token并验证token
 */

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
//        String token = httpServletRequest.getHeader("token");
        String token = null;
//        System.out.println(httpServletRequest.getHeader("Authorization"));
        if (httpServletRequest.getHeader("Authorization") == null){
            token = httpServletRequest.getHeader("token");
        }else if (httpServletRequest.getHeader("Authorization") != null){
            token = httpServletRequest.getHeader("Authorization");// 从 http 请求头中取出 token
        }
//        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if (token != null){
            token = token.split(" ")[1];
        }
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
//        System.out.println("UserLoginToken");
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            httpServletResponse.reset();
            if (userLoginToken.required()) {
                JSONObject json = new JSONObject();
                // 执行认证
                if (token == null) {
//                    json.put("success","false");
//                    json.put("msg","认证失败，未通过拦截器");
//                    json.put("code","50000");
//                    httpServletResponse.getWriter().append(json.toJSONString());
//                    System.out.println("认证失败，未通过拦截器");
                    Map<String,Object> map=new HashMap<>();
//                    map.put("msg","token is null");
                    map.put("code","660");
                    OutputStream outputStreamam = httpServletResponse.getOutputStream();
                    outputStreamam.write(JSONObject.toJSONString(map).getBytes());
                    outputStreamam.flush();
                    outputStreamam.close();
//                    httpServletResponse.getWriter().write(JSONObject.toJSONString(map));
                    return false;
                }
                // 获取 token 中的 user id
                String username = null;
                username = JWT.decode(token).getClaim("username").asString();
                System.out.println("username = "+username);
                User user = userService.getUserInfo(username);
                if (user == null) {
//                    json.put("success","false");
//                    json.put("msg","用户不存在，请重新登陆");
//                    json.put("code","50001");
//                    httpServletResponse.getWriter().append(json.toJSONString());
//                    System.out.println("认证失败，未通过拦截器");
                    Map<String,Object> map=new HashMap<>();
//                    map.put("message","error");
                    map.put("code","661");
                    OutputStream outputStreamam = httpServletResponse.getOutputStream();
                    outputStreamam.write(JSONObject.toJSONString(map).getBytes());
                    outputStreamam.flush();
                    outputStreamam.close();
//                    httpServletResponse.getWriter().write(JSONObject.toJSONString(map));
                    return false;
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                DecodedJWT jwt = jwtVerifier.verify(token);
//                json.put("success","success");
//                json.put("msg","认证通过");
//                json.put("issuer",jwt.getIssuer());
//                json.put("username",jwt.getClaim("username").asString());
//                json.put("expiresAt",jwt.getExpiresAt());
//                httpServletResponse.getWriter().append(json.toJSONString());
                Map<String,Object> map=new HashMap<>();
//                map.put("msg","success");
                map.put("code","666");
                map.put("username",jwt.getClaim("username").asString());
                map.put("expiresAt",jwt.getExpiresAt());
                OutputStream outputStreamam = httpServletResponse.getOutputStream();
                outputStreamam.write(JSONObject.toJSONString(map).getBytes());
                outputStreamam.flush();
//                outputStreamam.close();
//                httpServletResponse.getWriter().write(JSONObject.toJSONString(map));
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
