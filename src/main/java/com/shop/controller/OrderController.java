package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.entity.User;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/searchBuyerlist",method = RequestMethod.GET)
    public List<User> searchBuyerlist(int item_id){ return orderService.searchBuyerlist(item_id);}

    @RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
    public String updateGoods(int item_id, Goods newgoods){
        int result = orderService.updateGoods(item_id,newgoods);
        if (result >= 1) {
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping(value = "/AddToOrderWanted",method = RequestMethod.POST)
    public String AddToOrderWanted(int item_id,String name,String phonenumber,String address){
        int result = orderService.AddToOrderWanted(item_id, name, phonenumber, address);
        if (result >= 1) {
            return "success";
        }else {
            return "error";
        }
    }


}
