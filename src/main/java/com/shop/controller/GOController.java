package com.shop.controller;

import com.shop.annotation.UserLoginToken;
import com.shop.entity.GO;
import com.shop.entity.User;
import com.shop.service.GOService;
import com.shop.service.UserService;
import com.shop.token.TokenService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/go")
public class GOController {

    private String message = "error";

    @Autowired
    private GOService GOService;

    @RequestMapping(value = "/addGO")
    public Object addGO(HttpServletRequest request, HttpServletResponse response){
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        JSONObject jsonObject = new JSONObject();
        int result = GOService.addGO(item_id,order_id);
        if(result>=1){
            message = "success";
        } else{
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }
    @RequestMapping(value = "/searchGOByItemId")
    public Object searchGOByItemId(HttpServletRequest request, HttpServletResponse response){
        int item_id = Integer.parseInt(request.getParameter("item_id"));
//        int order_id = Integer.parseInt(request.getParameter("order_id"));
        JSONObject jsonObject = new JSONObject();
        GO go = GOService.searchGOByItemId(item_id);
        if(go != null){
            message = "success";
            jsonObject.put("GO",go);
        } else{
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    //@RequestMapping(value = "/searchGOByItemId")
    public Object searchGOByOrderId(HttpServletRequest request, HttpServletResponse response){
//        int item_id = Integer.parseInt(request.getParameter("item_id"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        JSONObject jsonObject = new JSONObject();
        GO go = GOService.searchGOByOrderId(order_id);
        if(go != null){
            message = "success";
            jsonObject.put("GO",go);
        } else{
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

}
