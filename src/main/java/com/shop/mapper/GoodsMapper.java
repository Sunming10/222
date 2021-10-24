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
     *根据username查找此用户是否有正在出售的商品
     * @param username
     * @return
     */
    Goods isHaveSellingGoods(String username);
    /**
     * 在Goods表中查找所有正在出售的商品
     * @param page
     * @return
     */
    List<Goods> searchSellingGoods(int page);

    /**
     * 在Goods表中查找所有商品
     * @return
     */
    List<Goods> searchHistoryGoods(String username,int page);

    /**
     * 在Goods表中查找所有商品(welcome)
     * @return
     */
    List<Goods> searchWelcomeGoods();

    /**
     * 在goods表中修改商品信息
     * @param
     * @param newgoods
     * @return
     */
    int updateGoods(Goods newgoods);

    /**
     * 查询冻结商品
     * @param
     * @param username
     * @return
     */

    List<Goods> searchFreezingGoods(String username,int page);



}
