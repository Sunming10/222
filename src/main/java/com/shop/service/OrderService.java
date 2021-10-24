package com.shop.service;

import com.shop.entity.Goods;
import com.shop.entity.Order;
import com.shop.entity.User;
import com.shop.mapper.GoodsMapper;
import com.shop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public List<Order> searchBuyerlist(int item_id){ return orderMapper.searchBuyerlist(item_id);}
    public Order searchFreezeGoodsBuyer(int item_id){ return orderMapper.searchFreezeGoodsBuyer(item_id);}
    public Order agreeOrderwanted(int order_id){
        int result = orderMapper.agreeOrderwanted(order_id);
        Order order = orderMapper.searchOrderByOrderId(order_id);
        orderMapper.updateOtherOrders(order.getItem_id());
        goodsMapper.updateGoodsState(order.getItem_id(),2);
        return order;
    }
    public int finishOrder(int item_id){
        int result = orderMapper.finishOrder(item_id);
        goodsMapper.updateGoodsState(item_id,3);
        return result;
    }
    public int cancelOrder(int item_id){
        int result =orderMapper.cancelOrder(item_id);
        goodsMapper.updateGoodsState(item_id,1);
        return result;
    }
    public int updateOtherOrders(int item_id){return orderMapper.updateOtherOrders(item_id);}
    public Order searchOrderByOrderId(int order_id){return orderMapper.searchOrderByOrderId(order_id);};
    public int addToOrderWanted(int item_id, String buyer_realname, String buyer_phonenumber, String buyer_address, int buy_sum,@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date create_time){
        return orderMapper.addToOrderWanted(item_id, buyer_realname, buyer_phonenumber, buyer_address,buy_sum,create_time);
    }
}
