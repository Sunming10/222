package com.shop.mapper;

import com.shop.entity.Goods;
import com.shop.entity.Order;
import com.shop.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderMapper {
    /**
     * 查看order表中商品号为item_number的买家列表
     * @param item_id
     * @return
     */
    List<Order> searchBuyerlist(String seller_username,int item_id);

    /**
     * 查看order表中商品号为item_number且正在交易中的的订单信息
     * @param item_id
     * @return
     */
    Order searchFreezeGoodsBuyer(String seller_username,int item_id);

    /**
     * 查看order表中商品意向买家名
     * @param
     * @return
     */
    List<Order> searchSellingGoodsBuyerRealname();

    /**
     * 同意意向买家
     * @param order_id
     * @return
     */
    int agreeOrderwanted(String seller_username,int order_id);

    /**
     * 完成交易(下架)
     * @param item_id
     * @return
     */
    int finishOrder(String seller_username,int item_id,String finish_time);

    /**
     * 取消交易(恢复)
     * @param item_id
     * @return
     */
    int cancelOrder(String seller_username,int item_id);

    /**
     * 通过订单id查询订单
     * @param seller_username
     * @param order_id
     * @return
     */
    Order searchOrderByOrderId(String seller_username,int order_id);

    /**
     * 查询完成订单
     * @param seller_username
     * @param page
     * @return
     */
    List<Order> searchFinishOrder(String seller_username,int page);

    /**
     * 在Order表中查找已完成交易商品的历史意向买家
     * @param seller_username
     * @param item_id
     * @return
     */
    List<Order> searchHistoryGoodsUnFinishedOrder(String seller_username, int item_id);

    /**
     * 查询交易中订单
     * @param seller_username
     * @param page
     * @return
     */
    List<Order> searchDealingOrder(String seller_username,int page);

    /**
     * 修改其余订单状态为关闭交易
     * @param seller_username
     * @param item_id
     * @return
     */
    int updateOtherOrders(String seller_username,int item_id);


    /**
     * 根据item_id(商品ID)有意向的购买者下单
     * @param item_id
     * @param seller_username
     * @param buyer_realname
     * @param buyer_phonenumber
     * @param buyer_address
     * @return
     */
    int addToOrderWanted(int item_id,String seller_username, String buyer_realname,String buyer_phonenumber,String buyer_address,int buy_sum,String create_time);
}
