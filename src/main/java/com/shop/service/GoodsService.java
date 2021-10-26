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
    public int updateGoodsState(String seller_username,int item_id,int newstate){
        return goodsMapper.updateGoodsState(seller_username,item_id, newstate);
    }
    public List<Goods> searchSellingGoods(int page){return goodsMapper.searchSellingGoods(page);}//一页8条
    public List<Goods> searchFreezingGoods(String seller_username,int page){return goodsMapper.searchFreezingGoods(seller_username,page);}//一页10条
    public List<Goods> searchHistoryGoods(String seller_username, int page){ return goodsMapper.searchHistoryGoods(seller_username,page);}//一页10条
    public int updateGoods(Goods newgoods){ return goodsMapper.updateGoods(newgoods);}
    public List<Goods> searchWelcomeGoods(){return  goodsMapper.searchWelcomeGoods();}
    public boolean isHaveSellingGoods(String username){
        if(goodsMapper.isHaveSellingGoods(username)==null){
            return false;
        }else {
            return true;
        }
        }
}
