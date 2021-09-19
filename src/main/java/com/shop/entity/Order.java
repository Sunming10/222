package com.shop.entity;

import java.util.Objects;

public class Order {
    private String order_id;
    private String item_id;
    private String seller_id;
    private String buyer_id;
    private String buyer_realname;
    private String buyer_phonenumber;
    private int buyer_buynumber;
    private String buyer_addres;

    public Order() {
        super();
    }

    public Order(String order_id, String item_id, String seller_id, String buyer_id, String buyer_realname, String buyer_phonenumber, int buyer_buynumber, String buyer_addres) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.seller_id = seller_id;
        this.buyer_id = buyer_id;
        this.buyer_realname = buyer_realname;
        this.buyer_phonenumber = buyer_phonenumber;
        this.buyer_buynumber = buyer_buynumber;
        this.buyer_addres = buyer_addres;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
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

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
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

    public int getBuyer_buynumber() {
        return buyer_buynumber;
    }

    public void setBuyer_buynumber(int buyer_buynumber) {
        this.buyer_buynumber = buyer_buynumber;
    }

    public String getBuyer_addres() {
        return buyer_addres;
    }

    public void setBuyer_addres(String buyer_addres) {
        this.buyer_addres = buyer_addres;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", item_id='" + item_id + '\'' +
                ", seller_id='" + seller_id + '\'' +
                ", buyer_id='" + buyer_id + '\'' +
                ", buyer_realname='" + buyer_realname + '\'' +
                ", buyer_phonenumber='" + buyer_phonenumber + '\'' +
                ", buyer_buynumber=" + buyer_buynumber +
                ", buyer_addres='" + buyer_addres + '\'' +
                '}';
    }
}
