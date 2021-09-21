package com.shop.service;

import com.shop.entity.Goods;
import com.shop.entity.User;
import com.shop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<User> searchBuyerlist(int item_id){ return orderMapper.searchBuyerlist(item_id);}
    public int updateGoods(int item_id, Goods newgoods){ return orderMapper.updateGoods(item_id,newgoods);}
    public int AddToOrderWanted(int item_id,String name,String phonenumber,String address){ return orderMapper.AddToOrderWanted(item_id, name, phonenumber, address);}
}
