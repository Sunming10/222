package com.shop.mapper;

import com.shop.entity.GO;
import com.shop.entity.Goods;
import com.shop.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface GOMapper {
    /**
     * 根据Goods向Goods表中添加信息
     * @param item_id
     * @param order_id
     * @return
     */
    int addGO(int item_id,int order_id);

    /**
     * 根据Goods向Goods表中添加信息
     * @param item_id
     * @return
     */
    GO searchGOByItemId(int item_id);

    /**
     * 根据Goods向Goods表中添加信息
     * @param order_id
     * @return
     */
    GO searchGOByOrderId(int order_id);

    /**
     * 根据Goods向Goods表中添加信息
     * @param item_id
     * @return
     */
    int deleteGOByItemId(int item_id);

    /**
     * 根据Goods向Goods表中添加信息
     * @param order_id
     * @return
     */
    int deleteGOByOrderId(int order_id);
}
