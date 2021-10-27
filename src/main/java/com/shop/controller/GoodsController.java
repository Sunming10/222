package com.shop.controller;

import com.shop.entity.GO;
import com.shop.entity.Goods;
import com.shop.entity.Order;
import com.shop.entity.Order_Goods;
import com.shop.service.GOService;
import com.shop.service.GoodsService;
import com.shop.service.OrderService;
import com.shop.service.UploadImageService;
import com.shop.utils.StringUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    private String message = "error";

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GOService goService;

    @Resource
    UploadImageService uploadImageService;

    //向Goods表中添加商品
    @RequestMapping(value = "/addGoods")
    public Object addGoods(HttpServletRequest request, HttpServletResponse response) {
        String goods_name = request.getParameter("goods_name");
        String seller_username = "admin";
        int goods_stock = 1;
//        String goods_img = uploadImageService.uploadQNImg((FileInputStream) file.getInputStream(), StringUtil.getRandomImgName(file.getOriginalFilename()));
        String goods_img = request.getParameter("goods_img");
        String goods_discribe = request.getParameter("goods_discribe");
        float goods_price = Float.parseFloat(request.getParameter("goods_price"));
        JSONObject jsonObject = new JSONObject();
        Goods goods = new Goods(goods_name,seller_username,goods_stock,goods_img,goods_discribe,goods_price);
        int result = goodsService.addGoods( goods);
        if (result >= 1) {
            message = "success";
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    //买家在goods表中查询goods详细信息
    @RequestMapping(value = "/searchGoods")
    public Object searchGoods(HttpServletRequest request, HttpServletResponse response){
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        JSONObject jsonObject = new JSONObject();
        Goods good = goodsService.searchGoods(item_id);
        if (good != null){
            message = "success";
            jsonObject.put("good",good);
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    //修改商品状态
    @RequestMapping(value = "/updateGoodsState")
    public Object updateGoodsState(HttpServletRequest request, HttpServletResponse response){
        String seller_username = request.getParameter("seller_username");
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        int newstate = Integer.parseInt(request.getParameter("newstate"));
        JSONObject jsonObject = new JSONObject();
        int result = goodsService.updateGoodsState(seller_username,item_id, newstate);
        if (result >= 1) {
            message = "success";
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    //在goods表中查找所有正在出售的商品。
    @RequestMapping(value = "/searchSellingGoods")
    public Object searchSellingGoods(HttpServletRequest request, HttpServletResponse response){
        int page = (Integer.parseInt(request.getParameter("page"))-1)*10;
        JSONObject jsonObject = new JSONObject();
        List<Goods> goods= goodsService.searchSellingGoods(page);
        message = "success";
        jsonObject.put("message",message);
        jsonObject.put("goods",goods);
        return jsonObject;
    }

    //在goods表中查找所有正在出售的商品。
    @RequestMapping(value = "/searchWelcomeGoods")
    public Object searchWelcomeGoods(){
        JSONObject jsonObject = new JSONObject();
        List<Goods> goods = goodsService.searchWelcomeGoods();
        message = "success";
        jsonObject.put("goods",goods);
        jsonObject.put("message",message);
        return jsonObject;
    }

    //在goods表中查询所有商品
    @RequestMapping(value = "/searchHistoryGoods")
    public Object searchHistoryGoods(HttpServletRequest request, HttpServletResponse response){
        String seller_username = request.getParameter("seller_username");
        int page = Integer.parseInt(request.getParameter("page"));
        page = (page-1)*10;
        JSONObject jsonObject = new JSONObject();
        List<Goods> goodsList = goodsService.searchHistoryGoods(seller_username,page);
        List<Order_Goods> list = new ArrayList<Order_Goods>();
        for (int i=0;i < goodsList.size();i++){
            Goods good = (Goods) goodsList.get(i);
            GO go = goService.searchGOByItemId(good.getItem_id());
            Order order = orderService.searchOrderByOrderId(seller_username, go.getOrder_id());
            Order_Goods order_goods = new Order_Goods(
                    order.getOrder_id(),
                    order.getBuyer_realname(),
                    order.getBuyer_phonenumber(),
                    order.getBuyer_address(),
                    order.getFinish_time(),
                    good.getItem_id(),
                    good.getGoods_name(),
                    good.getGoods_price(),
                    good.getGoods_img(),
                    good.getGoods_discribe());
            list.add(order_goods);
        }
        message = "success";
        jsonObject.put("message",message);
        jsonObject.put("list",list);
        return jsonObject;
    }

    //查询此用户是否有正在出售的商品
    @RequestMapping(value = "/isHaveSellingGoods")
    public boolean isHaveSellingGoods(String username){return goodsService.isHaveSellingGoods(username);}

    //修改商品信息
    @RequestMapping(value = "/updateGoods")
    public Object updateGoods(HttpServletRequest request, HttpServletResponse response){
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        String goods_name = request.getParameter("goods_name");
        String seller_username = "admin";
//        String goods_img = uploadImageService.uploadQNImg((FileInputStream) file.getInputStream(), StringUtil.getRandomImgName(file.getOriginalFilename()));
        String goods_img = request.getParameter("goods_img");
        String goods_discribe = request.getParameter("goods_discribe");
        float goods_price = Float.parseFloat(request.getParameter("goods_price"));
        JSONObject jsonObject = new JSONObject();
        Goods newgoods = new Goods(item_id,goods_name,seller_username,goods_img,goods_discribe,goods_price);
        int result = goodsService.updateGoods(newgoods);
        if (result >= 1) {
            message =  "success";
        }else {
            message = "error";
        }
        jsonObject.put("message",message);
        return  jsonObject;
    }

    //查看冻结商品
    @RequestMapping(value = "/searchFreezingGoods")
    public Object searchFreezingGoods(HttpServletRequest request, HttpServletResponse response){
        String seller_username = request.getParameter("seller_username");
        int page = (Integer.parseInt(request.getParameter("page"))-1)*10;
        JSONObject jsonObject = new JSONObject();
        List<Goods> goodsList = goodsService.searchFreezingGoods(seller_username,page);
        List<Order_Goods> list = new ArrayList<Order_Goods>();
        for (int i=0;i < goodsList.size();i++){
            Goods good = (Goods) goodsList.get(i);
            GO go = goService.searchGOByItemId(good.getItem_id());
            Order order = orderService.searchOrderByOrderId(seller_username, go.getOrder_id());
            Order_Goods order_goods = new Order_Goods(
                    order.getOrder_id(),
                    order.getBuyer_realname(),
                    order.getBuyer_phonenumber(),
                    order.getBuyer_address(),
                    good.getItem_id(),
                    good.getGoods_name(),
                    good.getGoods_price(),
                    good.getGoods_img(),
                    good.getGoods_discribe());
            list.add(order_goods);
        }
        message = "success";
        jsonObject.put("message",message);
        jsonObject.put("list",list);
        return jsonObject;
    }
}
