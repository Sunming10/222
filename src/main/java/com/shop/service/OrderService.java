package com.shop.service;

import com.shop.entity.Goods;
import com.shop.entity.User;
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

    public List<Goods> searchBuyerlist(int item_id){ return orderMapper.searchBuyerlist(item_id);}

    public int addToOrderWanted(int item_id, String buyer_realname, String buyer_phonenumber, String buyer_address, int buy_sum,@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date create_time){
        return orderMapper.addToOrderWanted(item_id, buyer_realname, buyer_phonenumber, buyer_address,buy_sum,create_time);
    }
}
