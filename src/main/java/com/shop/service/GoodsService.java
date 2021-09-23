package com.shop.service;

import com.shop.entity.Goods;
import com.shop.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    public int addGoods(String goods_name,String seller_username,int goods_stock,String goods_img,String goods_describe,int goods_price){
        return goodsMapper.addGoods( goods_name, seller_username, goods_stock, goods_img, goods_describe, goods_price);
    }
    public Goods searchGoods(int item_id){ return goodsMapper.searchGoods(item_id); }
    public int updateGoodsState(int item_id,int newstate){
        return goodsMapper.updateGoodsState(item_id, newstate);
    }
    public List<Goods> searchOffGoods(String username){ return goodsMapper.searchOffGoods(username);}
    public List<Goods> searchSellingGoods(){return goodsMapper.searchSellingGoods();}
}
