package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.entity.Order;
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
    public List<Order> searchBuyerlist(int item_id){ return orderService.searchBuyerlist(item_id);}

    //查看交易中的某商品对应的订单信息
    @RequestMapping(value = "/searchFreezeGoodsBuyer")
    public Order searchFreezeGoodsBuyer(int item_id){ return orderService.searchFreezeGoodsBuyer(item_id);}

    //同意意向买家
    @RequestMapping(value = "/agreeOrderwanted")
    public Order agreeOrderwanted(int order_id) {
        return orderService.agreeOrderwanted(order_id);
    }

    //通过订单号查询订单
//    @RequestMapping(value = "/searchOrderByOrderId")
//    public Order searchOrderByOrderId(int order_id){return orderService.searchOrderByOrderId(order_id);}

    //通过订单id查询商品id
//    @RequestMapping(value = "/searchItemIdByOrderId")
//    public int searchItemIdByOrderId(int order_id){return orderService.searchItemIdByOrderId(order_id);}

    //完成交易(下架)
    @RequestMapping(value = "/finishOrder")
    public void finishOrder(int item_id){
        orderService.finishOrder(item_id);
    }

    //取消交易(恢复)
    @RequestMapping(value = "/cancelOrder")
    public void cancelOrder(int item_id){
        orderService.cancelOrder(item_id);
    }

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
