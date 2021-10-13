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

    public int addGoods(Goods Goods){
        return goodsMapper.addGoods(Goods);
    }
    public Goods searchGoods(int item_id){ return goodsMapper.searchGoods(item_id); }
    public int updateGoodsState(int item_id,int newstate){
        return goodsMapper.updateGoodsState(item_id, newstate);
    }
    public List<Goods> searchOffGoods(String username){ return goodsMapper.searchOffGoods(username);}
    public List<Goods> searchSellingGoods(){return goodsMapper.searchSellingGoods();}
    public List<Goods> searchAllGoods(){ return goodsMapper.searchAllGoods();}
    public int updateGoods(int item_id, Goods newgoods){ return goodsMapper.updateGoods(item_id,newgoods);}
}