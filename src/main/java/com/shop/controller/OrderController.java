package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.entity.User;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //查看商品意向购买买家
    @RequestMapping(value = "/searchBuyerlist")
    public List<Goods> searchBuyerlist( int item_id){ return orderService.searchBuyerlist(item_id);}




    //意向购买者下单
    @RequestMapping(value = "/addToOrderWanted")
    public String addToOrderWanted(int item_id, String buyer_realname, String buyer_phonenumber, String buyer_address, int buy_sum,@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date create_time){
        int result = orderService.addToOrderWanted(item_id, buyer_realname, buyer_phonenumber, buyer_address,buy_sum,create_time);
        if (result >= 1) {
            return "success";
        }else {
            return "error";
        }
    }


}
