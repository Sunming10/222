package com.shop.controller;

import com.shop.entity.Goods;
import com.shop.entity.Order;
import com.shop.entity.Order_Goods;
import com.shop.service.GoodsService;
import com.shop.service.OrderService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

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
    @RequestMapping(value = "/searchGoods")
    public Goods searchGoods( int item_id){
        Goods goods = goodsService.searchGoods(item_id);
        return goods;
    }

    //修改商品状态
    @RequestMapping(value = "/updateGoodsState")
    public String updateGoodsState( int item_id,int newstate){
        int result = goodsService.updateGoodsState(item_id, newstate);
        if (result >= 1) {
            return "success";
        }else {
            return "error";
        }
    }

    //在goods表中查找所有正在出售的商品。
    @RequestMapping(value = "/searchSellingGoods")
    public List<Goods> searchSellingGoods(int page){
        page = (page-1)*10;
        return goodsService.searchSellingGoods(page);
    }

    //在goods表中查找所有正在出售的商品。
    @RequestMapping(value = "/searchWelcomeGoods")
    public Object searchWelcomeGoods(){
        JSONObject jsonObject = new JSONObject();
        List<Goods> goods = goodsService.searchWelcomeGoods();
        jsonObject.put("goods",goods);
        return jsonObject;
    }

    //在goods表中查询所有商品
    @RequestMapping(value = "/searchHistoryGoods")
    public void searchHistoryGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int page = Integer.parseInt(request.getParameter("page"));
        page = (page-1)*10;
        JSONObject jsonObject = new JSONObject();
        List<Goods> goodsList = goodsService.searchHistoryGoods(username,page);
        List<Order> orderList = orderService.searchFinishOrder(username,page);
        List<Order_Goods> list = new ArrayList<Order_Goods>();
        for (int i=0;i < goodsList.size();i++){
            Goods goods = (Goods) goodsList.get(i);
            Order order = (Order) orderList.get(i);
            Order_Goods order_goods = new Order_Goods(
                    order.getOrder_id(),
                    order.getBuyer_realname(),
                    order.getBuyer_phonenumber(),
                    order.getBuyer_address(),
                    order.getFinish_time(),
                    goods.getItem_id(),
                    goods.getGoods_name(),
                    goods.getGoods_price(),
                    goods.getGoods_img(),
                    goods.getGoods_discribe());
            list.add(order_goods);
        }

//        response.getOutputStream().write(jsonObject.toJSONString().getBytes());
        Map<String,Object> map=new HashMap<>();
//        map.put("goods",goodsList);
//        map.put("orders",orderList);
        map.put("list",list);
        OutputStream outputStreamam = response.getOutputStream();
        outputStreamam.write(JSONObject.toJSONString(map).getBytes());
        outputStreamam.flush();
        outputStreamam.close();
    }

    //查询此用户是否有正在出售的商品
    @RequestMapping(value = "/isHaveSellingGoods")
    public boolean isHaveSellingGoods(String username){return goodsService.isHaveSellingGoods(username);}

    //修改商品信息
    @RequestMapping(value = "/updateGoods")
    public String updateGoods(@RequestBody Goods newgoods){
        int result = goodsService.updateGoods(newgoods);
        if (result >= 1) {
            return "success";
        }else {
            return "error";
        }
    }

    //查看冻结商品
    @RequestMapping(value = "/searchFreezingGoods")
    public List<Goods> searchFreezingGoods(String username , int page){
        page = (page-1)*10;
        return goodsService.searchFreezingGoods(username,page);
    }


}
