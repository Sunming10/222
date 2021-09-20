package com.shop.entity;

public class Buyer {
    private int id;
    private String item_id;
    private String buyer_id;
    private String buyer_realname;
    private String buyer_phonenumber;
    private int buy_sum;
    private String buyer_addres;

    public Buyer() {
        super();
    }

    public Buyer(int id, String item_id, String buyer_id, String buyer_realname, String buyer_phonenumber, int buyer_buynumber, String buyer_addres) {
        this.id = id;
        this.item_id = item_id;
        this.buyer_id = buyer_id;
        this.buyer_realname = buyer_realname;
        this.buyer_phonenumber = buyer_phonenumber;
        this.buyer_buynumber = buyer_buynumber;
        this.buyer_addres = buyer_addres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
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
        return "Buyer{" +
                "id='" + id + '\'' +
                ", item_id='" + item_id + '\'' +
                ", buyer_id='" + buyer_id + '\'' +
                ", buyer_realname='" + buyer_realname + '\'' +
                ", buyer_phonenumber='" + buyer_phonenumber + '\'' +
                ", buyer_buynumber=" + buyer_buynumber +
                ", buyer_addres='" + buyer_addres + '\'' +
                '}';
    }
}
