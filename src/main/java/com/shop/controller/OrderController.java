package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.entity.User;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //查看商品意向购买买家
    @RequestMapping(value = "/searchBuyerlist",method = RequestMethod.POST)
    public List<User> searchBuyerlist(@RequestBody int item_id){ return orderService.searchBuyerlist(item_id);}

    //修改商品信息
    @RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
    public String updateGoods(@RequestBody int item_id, Goods newgoods){
        int result = orderService.updateGoods(item_id,newgoods);
        if (result >= 1) {
            return "success";
        }else {
            return "error";
        }
    }

    //意向购买者下单
    @RequestMapping(value = "/addToOrderWanted",method = RequestMethod.POST)
    public String addToOrderWanted(@RequestBody int item_id,String name,String phonenumber,String address){
        int result = orderService.addToOrderWanted(item_id, name, phonenumber, address);
        if (result >= 1) {
            return "success";
        }else {
            return "error";
        }
    }


}
