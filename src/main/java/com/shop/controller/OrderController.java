package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.entity.Order;
import com.shop.entity.User;
import com.shop.service.OrderService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void addToOrderWanted(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        String seller_username = "admin";
        String buyer_realname = request.getParameter("buyer_realname");
        String buyer_phonenumber = request.getParameter("buyer_phonenumber");
        String buyer_address = request.getParameter("buyer_address");
        int buy_sum = 1;
        String create_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        int result = orderService.addToOrderWanted(item_id, seller_username,buyer_realname, buyer_phonenumber, buyer_address,buy_sum,create_time);
        Map<String,Object> map=new HashMap<>();
        String message = null;
        if (result >=1){
            message = "success";
        }else {
            message = "error";
        }
        map.put("message",message);
        OutputStream outputStreamam = response.getOutputStream();
        outputStreamam.write(JSONObject.toJSONString(map).getBytes());
        outputStreamam.flush();
        outputStreamam.close();
    }


}
