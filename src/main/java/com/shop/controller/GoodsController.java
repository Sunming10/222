package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //向Goods表中添加商品
    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    public String addGoods(Goods goods){
        int result = goodsService.addGoods(goods);
        if (result >= 1) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    //买家在goods表中查询goods详细信息
    @RequestMapping(value = "/searchGoods",method = RequestMethod.GET)
    public Goods searchGoods(int item_id){
        Goods Goods = goodsService.searchGoods(item_id);
        return Goods;
    }

    //修改商品状态
    @RequestMapping(value = "/updateGoodsState",method = RequestMethod.POST)
    public String updateGoodsState(int item_id,int newstate){
        int result = goodsService.updateGoodsState(item_id, newstate);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    //卖家在goods表中查看下架商品，返回一个List<Goods>
    @RequestMapping(value = "/searchOffGoods",method = RequestMethod.GET)
    public List<Goods> searchOffGoods(String username){
        return goodsService.searchOffGoods(username);
    }

    //在goods表中查找所有正在出售的商品。
    @RequestMapping(value = "/searchSellingGoods",method = RequestMethod.GET)
    public List<Goods> searchSellingGoods(){
        return goodsService.searchSellingGoods();
    }




}
