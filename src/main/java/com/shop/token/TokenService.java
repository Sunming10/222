package com.shop.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.shop.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 12 * 60 * 60 * 1000;//一小时有效时间
        Date expiresAt = new Date(currentTime);
        String token = "";
//        Map<String,Object> header=new HashMap<>();
//        header.put("typ","JWT");
//        header.put("alg","HS256");

        token = JWT.create()
//                .withHeader(header)
                //存储自己想要留存给客户端浏览器的内容
                .withAudience(user.getUserName())
                .withClaim("username",user.getUserName())
                .withIssuedAt(start)
                .withExpiresAt(expiresAt)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
