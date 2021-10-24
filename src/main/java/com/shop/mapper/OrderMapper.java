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
    List<Order> searchBuyerlist(int item_id);

    /**
     * 查看order表中商品号为item_number且正在交易中的的订单信息
     * @param item_id
     * @return
     */
    Order searchFreezeGoodsBuyer(int item_id);

    /**
     * 同意意向买家
     * @param order_id
     * @return
     */
    int agreeOrderwanted(int order_id);


    /**
     * 通过订单id查询订单
     * @param order_id
     * @return
     */
    Order searchOrderByOrderId(int order_id);

    /**
     * 完成交易(下架)
     * @param item_id
     * @return
     */
    int finishOrder(int item_id);

    /**
     * 查询完成订单
     * @param seller_username
     * @return
     */
    List<Order> searchFinishOrder(String seller_username,int page);

    /**
     * 取消交易(恢复)
     * @param item_id
     * @return
     */
    int cancelOrder(int item_id);

    /**
     * 修改其余订单状态为关闭交易
     * @param item_id
     * @return
     */
    int updateOtherOrders(int item_id);


    /**
     * 根据item_id(商品ID)有意向的购买者下单
     * @param item_id
     * @param buyer_realname
     * @param buyer_phonenumber
     * @param buyer_address
     * @return
     */
    int addToOrderWanted(int item_id,String buyer_realname,String buyer_phonenumber,String buyer_address,int buy_sum,@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date create_time);
}
