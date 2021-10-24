package com.shop.entity;

public class Order_Goods {
    private int order_id;
    private String buyer_realname;
    private String buyer_phonenumber;
    private String buyer_address;
    private String finish_time;
    private int item_id;
    private String goods_name;
    private float goods_price;
    private String goods_img;
    private String goods_discribe;

    public Order_Goods() {
    }

    @Override
    public String toString() {
        return "Order_Goods{" +
                "order_id=" + order_id +
                ", buyer_realname='" + buyer_realname + '\'' +
                ", buyer_phonenumber='" + buyer_phonenumber + '\'' +
                ", buyer_address='" + buyer_address + '\'' +
                ", finish_time='" + finish_time + '\'' +
                ", item_id=" + item_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price=" + goods_price +
                ", goods_img='" + goods_img + '\'' +
                ", goods_discribe='" + goods_discribe + '\'' +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getBuyer_realname() {
        return buyer_realname;
    }

    public void setBuyer_realname(String buyer_realname) {
        this.buyer_realname = buyer_realname;
    }

    public String getBuyer_phonenumber() {
        return buyer_phonenumber;
    }

    public void setBuyer_phonenumber(String buyer_phonenumber) {
        this.buyer_phonenumber = buyer_phonenumber;
    }

    public String getBuyer_address() {
        return buyer_address;
    }

    public void setBuyer_address(String buyer_address) {
        this.buyer_address = buyer_address;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public float getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(float goods_price) {
        this.goods_price = goods_price;
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

    public Order_Goods(int order_id, String buyer_realname, String buyer_phonenumber, String buyer_address, String finish_time, int item_id, String goods_name, float goods_price, String goods_img, String goods_discribe) {
        this.order_id = order_id;
        this.buyer_realname = buyer_realname;
        this.buyer_phonenumber = buyer_phonenumber;
        this.buyer_address = buyer_address;
        this.finish_time = finish_time;
        this.item_id = item_id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_img = goods_img;
        this.goods_discribe = goods_discribe;
    }
}
