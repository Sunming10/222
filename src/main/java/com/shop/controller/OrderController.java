package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.entity.Order;
import com.shop.service.GOService;
import com.shop.service.GoodsService;
import com.shop.service.OrderService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private String message = "error";

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GOService goService;

    //查看商品意向购买买家
    @RequestMapping(value = "/searchBuyerlist")
    public Object searchBuyerlist(HttpServletRequest request, HttpServletResponse response){
        String seller_username = request.getParameter("seller_username");
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        JSONObject jsonObject = new JSONObject();
        List<Order> orderList = orderService.searchBuyerlist(seller_username,item_id);
        message = "success";
        jsonObject.put("orders",orderList);
        jsonObject.put("message",message);
        return jsonObject;
    }

    //查看商品意向购买买家名
    @RequestMapping(value = "/searchSellingGoodsBuyerRealname")
    public Object searchSellingGoodsBuyerRealname(HttpServletRequest request, HttpServletResponse response){
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        JSONObject jsonObject = new JSONObject();
        List<String> stringList =  orderService.searchSellingGoodsBuyerRealname();
        message = "success";
        jsonObject.put("stringList",stringList);
        jsonObject.put("message",message);
        return jsonObject;
    }

    //查看交易中的某商品对应的订单信息
    @RequestMapping(value = "/searchFreezeGoodsBuyer")
    public Object searchFreezeGoodsBuyer(HttpServletRequest request, HttpServletResponse response){
        String seller_username = request.getParameter("seller_username");
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        JSONObject jsonObject = new JSONObject();
        Order order = orderService.searchFreezeGoodsBuyer(seller_username,item_id);
        if (order != null){
            message = "success";
            jsonObject.put("order",order);
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    //查看已完成交易商品的历史意向买家
    @RequestMapping(value = "/searchHistoryGoodsUnFinishedOrder")
    public Object searchHistoryGoodsUnFinishedOrder(HttpServletRequest request, HttpServletResponse response){
        String seller_username = request.getParameter("seller_username");
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        JSONObject jsonObject = new JSONObject();
        List<Order> orderList = orderService.searchHistoryGoodsUnFinishedOrder(seller_username,item_id);
        message = "success";
        jsonObject.put("message",message);
        jsonObject.put("orderList",orderList);
        return jsonObject;
    }

    //同意意向买家
    @RequestMapping(value = "/agreeOrderwanted")
    public Object agreeOrderwanted(HttpServletRequest request, HttpServletResponse response) {
        String seller_username = request.getParameter("seller_username");
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        JSONObject jsonObject = new JSONObject();
        int result = goService.addGO(orderService.searchOrderByOrderId(seller_username,order_id).getItem_id(),order_id);
        Order order = orderService.agreeOrderwanted(seller_username,order_id);
        if (order != null){
            message = "success";
            jsonObject.put("order",order);
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    //完成交易(下架)
    @RequestMapping(value = "/finishOrder")
    public Object finishOrder(HttpServletRequest request, HttpServletResponse response){
        String seller_username = request.getParameter("seller_username");
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        JSONObject jsonObject = new JSONObject();
        String finish_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        int result = orderService.finishOrder(seller_username,item_id,finish_time);
        if (result >=1){
            message = "success";
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    //取消交易(恢复)
    @RequestMapping(value = "/cancelOrder")
    public Object cancelOrder(HttpServletRequest request, HttpServletResponse response){
        String seller_username = request.getParameter("seller_username");
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        JSONObject jsonObject = new JSONObject();
        goService.deleteGOByItemId(item_id);
        int result = orderService.cancelOrder(seller_username,item_id);
        if (result >=1){
            message = "success";
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;

    }

    //意向购买者下单
    @RequestMapping(value = "/addToOrderWanted")
    public Object addToOrderWanted(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        Goods good = goodsService.searchGoods(item_id);
        String seller_username = good.getSeller_username();
        String buyer_realname = request.getParameter("buyer_realname");
        String buyer_phonenumber = request.getParameter("buyer_phonenumber");
        String buyer_address = request.getParameter("buyer_address");
        int buy_sum = 1;
        String create_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        JSONObject jsonObject = new JSONObject();
        int result = orderService.addToOrderWanted(item_id, seller_username,buyer_realname, buyer_phonenumber, buyer_address,buy_sum,create_time);
        if (result >=1){
            message = "success";
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }


}
