package com.shop.entity;

public class Order {
    private String order_id;
    private String item_id;
    private String seller_id;
    private String buyer_id;
    private String buyer_realname;
    private String buyer_phonenumber;
    private int buyer_sum;
    private String buyer_address;
    private int state;//int,1表示进行中，2表示交易成功，3表示买家退款，4表示卖家关闭交易，5表示申请中
    private String create_time;
    private String finish_time;

    public Order() {
        super();
    }

    public Order(String order_id, String item_id, String seller_id, String buyer_realname, String buyer_phonenumber, int buyer_sum, String buyer_address, int state, String create_time, String finish_time) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.seller_id = seller_id;
        this.buyer_realname = buyer_realname;
        this.buyer_phonenumber = buyer_phonenumber;
        this.buyer_sum = buyer_sum;
        this.buyer_address = buyer_address;
        this.state = state;
        this.create_time = create_time;
        this.finish_time = finish_time;
    }

    public Order(String order_id, String item_id, String seller_id, String buyer_id, String buyer_realname, String buyer_phonenumber, int buyer_sum, String buyer_address, int state, String create_time, String finish_time) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.seller_id = seller_id;
        this.buyer_id = buyer_id;
        this.buyer_realname = buyer_realname;
        this.buyer_phonenumber = buyer_phonenumber;
        this.buyer_sum = buyer_sum;
        this.buyer_address = buyer_address;
        this.state = state;
        this.create_time = create_time;
        this.finish_time = finish_time;
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

    public int getBuyer_sum() {
        return buyer_sum;
    }

    public void setBuyer_sum(int buyer_sum) {
        this.buyer_sum = buyer_sum;
    }

    public String getBuyer_address() {
        return buyer_address;
    }

    public void setBuyer_address(String buyer_address) {
        this.buyer_address = buyer_address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
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
                ", buyer_sum=" + buyer_sum +
                ", buyer_address='" + buyer_address + '\'' +
                ", state=" + state +
                ", create_time='" + create_time + '\'' +
                ", finish_time='" + finish_time + '\'' +
                '}';
    }
}
