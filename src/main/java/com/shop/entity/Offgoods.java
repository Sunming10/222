package com.shop.entity;

import java.sql.Date;
import java.util.Objects;

public class Offgoods {
    private String id;
    private Long order_id;
    private String item_id;
    private String seller_id;
    private Date trade_time;
    private int trade_result;

    public Offgoods() {
        super();
    }

    public Offgoods(String id, String item_id, String seller_id, int trade_result) {
        this.id = id;
        this.item_id = item_id;
        this.seller_id = seller_id;
        this.trade_result = trade_result;
    }

    public Offgoods(String id, Long order_id, String item_id, String seller_id, Date trade_time, int trade_result) {
        this.id = id;
        this.order_id = order_id;
        this.item_id = item_id;
        this.seller_id = seller_id;
        this.trade_time = trade_time;
        this.trade_result = trade_result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public Date getTrade_time() {
        return trade_time;
    }

    public void setTrade_time(Date trade_time) {
        this.trade_time = trade_time;
    }

    public int getTrade_result() {
        return trade_result;
    }

    public void setTrade_result(int trade_result) {
        this.trade_result = trade_result;
    }

    @Override
    public String toString() {
        return "Offgoods{" +
                "id='" + id + '\'' +
                ", order_id=" + order_id +
                ", item_id='" + item_id + '\'' +
                ", seller_id='" + seller_id + '\'' +
                ", trade_time=" + trade_time +
                ", trade_result=" + trade_result +
                '}';
    }
}
