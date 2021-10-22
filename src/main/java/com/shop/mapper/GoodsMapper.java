package com.shop.mapper;

import com.shop.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    /**
     * 根据Goods向Goods表中添加信息
     * @param Goods
     * @return
     */
    int addGoods(Goods Goods);

    /**
     * 根据item_id(商品ID)向Godds表中查询详细信息
     * @param item_id
     * @return
     */
    Goods searchGoods(int item_id);

    /**
     * 根据item_id(商品ID),newstate(商品状态)向Goods表中更新商品状态信息
     * @param item_id
     * @param newstate
     * @return
     */
    int updateGoodsState(int item_id,int newstate);

    /**
     * 根据username向Goods表中查看下架商品信息
     * @param username
     * @return
     */
    List<Goods> searchOffGoods(String username);

    /**
     *根据username查找此用户是否有正在出售的商品
     * @param username
     * @return
     */
    Goods isHaveSellingGoods(String username);
    /**
     * 在Goods表中查找所有正在出售的商品
     * @return
     */
    List<Goods> searchSellingGoods();

    /**
     * 在Goods表中查找所有商品
     * @return
     */
    List<Goods> searchAllGoods();

    /**
     * 在goods表中修改商品信息
     * @param
     * @param newgoods
     * @return
     */
    int updateGoods(Goods newgoods);

}
