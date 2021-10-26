package com.shop.service;

import com.shop.entity.GO;
import com.shop.mapper.GOMapper;
import com.shop.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GOService {
    @Autowired
    private GOMapper GOMapper;

    public int addGO(int item_id,int order_id){return GOMapper.addGO(item_id,order_id);}
    public GO searchGOByItemId(int item_id){return GOMapper.searchGOByItemId(item_id);}
    public GO searchGOByOrderId(int order_id){return GOMapper.searchGOByOrderId(order_id);}
    public int deleteGOByItemId(int item_id){return GOMapper.deleteGOByItemId(item_id);}
    public int deleteGOByOrderId(int order_id){return GOMapper.deleteGOByOrderId(order_id);}

}
