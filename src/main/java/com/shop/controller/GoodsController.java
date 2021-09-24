package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String addGoods(@RequestBody Goods Goods){
        int result = goodsService.addGoods( Goods);
        if (result >= 1) {
            return "success";
        }else {
            return "error";
        }
    }

    //买家在goods表中查询goods详细信息
    @RequestMapping(value = "/searchGoods",method = RequestMethod.POST)
    public Goods searchGoods(@RequestBody int item_id){
        Goods Goods = goodsService.searchGoods(item_id);
        return Goods;
    }

    //修改商品状态
    @RequestMapping(value = "/updateGoodsState",method = RequestMethod.POST)
    public String updateGoodsState(@RequestBody int item_id,int newstate){
        int result = goodsService.updateGoodsState(item_id, newstate);
        if (result >= 1) {
            return "success";
        }else {
            return "error";
        }
    }

    //卖家在goods表中查看下架商品，返回一个List<Goods>
    @RequestMapping(value = "/searchOffGoods",method = RequestMethod.POST)
    public List<Goods> searchOffGoods(@RequestBody String username){
        return goodsService.searchOffGoods(username);
    }

    //在goods表中查找所有正在出售的商品。
    @RequestMapping(value = "/searchSellingGoods",method = RequestMethod.GET)
    public List<Goods> searchSellingGoods( ){
        return goodsService.searchSellingGoods();
    }




}
