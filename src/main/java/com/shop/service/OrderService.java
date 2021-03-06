package com.shop.service;

import com.shop.entity.Goods;
import com.shop.entity.Order;
import com.shop.entity.User;
import com.shop.mapper.GoodsMapper;
import com.shop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public static String hideCardNo(String str) {
        int length = str.length();
        int beforeLength = 1;
        int afterLength = 0;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<4; i++) {
            if(i == 0) {
                sb.append(str.charAt(i));
            } else {
                sb.append(replaceSymbol);
            }
        }
        return sb.toString();
    }

    public List<Order> searchBuyerlist(String seller_username,int item_id){ return orderMapper.searchBuyerlist(seller_username,item_id);}
    public Order searchFreezeGoodsBuyer(String seller_username,int item_id){ return orderMapper.searchFreezeGoodsBuyer(seller_username,item_id);}
    public Order agreeOrderwanted(String seller_username,int order_id){
        int result = orderMapper.agreeOrderwanted(seller_username,order_id);
        Order order = orderMapper.searchOrderByOrderId(seller_username,order_id);
        orderMapper.updateOtherOrders(seller_username,order.getItem_id());
        goodsMapper.updateGoodsState(seller_username,order.getItem_id(),2);
        return order;
    }
    public List<String> searchSellingGoodsBuyerRealname(){
        List<String> Strings = new ArrayList<>();
        List<Order> orderList = orderMapper.searchSellingGoodsBuyerRealname();
        String str;
        for (int i=0;i<orderList.size();i++){
            str = hideCardNo(orderList.get(i).getBuyer_realname());
            Strings.add(str);
        }
        return Strings; }
    public List<Order> searchHistoryGoodsUnFinishedOrder(String seller_username,int item_id){
        return orderMapper.searchHistoryGoodsUnFinishedOrder(seller_username,item_id);
    }
    public int finishOrder(String seller_username,int item_id,String finish_time){
        int result = orderMapper.finishOrder(seller_username,item_id,finish_time);
        goodsMapper.updateGoodsState(seller_username,item_id,3);
        return result;
    }
    public Order searchOrderByOrderId(String seller_username,int order_id){return orderMapper.searchOrderByOrderId(seller_username,order_id);}
    public  List<Order> searchFinishOrder(String seller_username,int page){return orderMapper.searchFinishOrder(seller_username,page);}
    public  List<Order> searchDealingOrder(String seller_username,int page){return orderMapper.searchDealingOrder(seller_username,page);}
    public int cancelOrder(String seller_username,int item_id){
        int result = orderMapper.cancelOrder(seller_username,item_id);
        goodsMapper.updateGoodsState(seller_username,item_id,1);
        return result;
    }
    public int addToOrderWanted(int item_id,String seller_username ,String buyer_realname,String buyer_phonenumber,String buyer_address,int buy_sum,String create_time){
        return orderMapper.addToOrderWanted(item_id, seller_username,buyer_realname, buyer_phonenumber, buyer_address,buy_sum,create_time);
    }
}
