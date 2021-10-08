package com.shop.mapper;

import com.shop.entity.Goods;
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
    List<Goods> searchBuyerlist(int item_id);



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
