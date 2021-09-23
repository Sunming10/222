package com.shop.mapper;

import com.shop.entity.Goods;
import com.shop.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    /**
     * 查看order表中商品号为item_number的买家列表
     * @param item_id
     * @return
     */
    List<User> searchBuyerlist(int item_id);

    /**
     * 在goods表中修改商品信息
     * @param item_id
     * @param newgoods
     * @return
     */
    int updateGoods(int item_id,Goods newgoods);

    /**
     * 根据item_id(商品ID)有意向的购买者下单
     * @param item_id
     * @param buyer_username
     * @param buyer_phonenumber
     * @param buyer_address
     * @return
     */
    int AddToOrderWanted(int item_id,String buyer_username,String buyer_phonenumber,String buyer_address);
}
