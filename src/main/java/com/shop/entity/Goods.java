package com.shop.entity;

public class Goods {
    private int item_id;
    private String goods_name;
    private String seller_username;
    private int goods_stock;
    private String goods_img;
    private String goods_discribe;
    private String goods_class;
    private int goods_price;
    private int goods_state;//int型 1表示在售，2表示冻结，3表示下架

    public Goods() {
        super();
    }

    public Goods(String goods_name, String seller_username, int goods_stock, String goods_img, String goods_discribe, int goods_price) {
        this.goods_name = goods_name;
        this.seller_username = seller_username;
        this.goods_stock = goods_stock;
        this.goods_img = goods_img;
        this.goods_discribe = goods_discribe;
        this.goods_price = goods_price;
    }

    public Goods(int item_id, String goods_name, String seller_username, int goods_stock, String goods_img, String goods_discribe, int goods_price, int goods_state) {
        this.item_id = item_id;
        this.goods_name = goods_name;
        this.seller_username = seller_username;
        this.goods_stock = goods_stock;
        this.goods_img = goods_img;
        this.goods_discribe = goods_discribe;
        this.goods_price = goods_price;
        this.goods_state = goods_state;
    }

    public int getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(int goods_price) {
        this.goods_price = goods_price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(int goods_stock) {
        this.goods_stock = goods_stock;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getSeller_username() {
        return seller_username;
    }

    public void setSeller_username(String seller_username) {
        this.seller_username = seller_username;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public String getGoods_discribe() {
        return goods_discribe;
    }

    public void setGoods_discribe(String goods_discribe) {
        this.goods_discribe = goods_discribe;
    }

    public int getGoods_state() {
        return goods_state;
    }

    public void setGoods_state(int goods_state) {
        this.goods_state = goods_state;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "item_id=" + item_id +
                ", goods_name='" + goods_name + '\'' +
                ", seller_username='" + seller_username + '\'' +
                ", goods_stock=" + goods_stock +
                ", goods_img='" + goods_img + '\'' +
                ", goods_discribe='" + goods_discribe + '\'' +
                ", goods_price=" + goods_price +
                ", goods_state=" + goods_state +
                '}';
    }
}
