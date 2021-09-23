package com.shop.entity;

public class Order {
    private int order_id;
    private int item_id;
    private String seller_username ;
    private String buyer_username ;
    private String buyer_realname;
    private String buyer_phonenumber;
    private String buyer_address;
    private int buy_sum;
    private int state;//int,1表示进行中，2表示交易成功，3表示买家退款，4表示卖家关闭交易，5表示申请中
    private String create_time;
    private String finish_time;

    public Order() {
        super();
    }

    public Order(int order_id, int item_id, String seller_username, String buyer_username, String buyer_realname, String buyer_phonenumber, String buyer_address, int buy_sum, int state, String create_time, String finish_time) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.seller_username = seller_username;
        this.buyer_username = buyer_username;
        this.buyer_realname = buyer_realname;
        this.buyer_phonenumber = buyer_phonenumber;
        this.buyer_address = buyer_address;
        this.buy_sum = buy_sum;
        this.state = state;
        this.create_time = create_time;
        this.finish_time = finish_time;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getBuy_sum() {
        return buy_sum;
    }

    public void setBuy_sum(int buy_sum) {
        this.buy_sum = buy_sum;
    }

    public Order(int order_id, int item_id, String seller_username, String buyer_realname, String buyer_phonenumber, String buyer_address, int buy_sum, int state, String create_time, String finish_time) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.seller_username = seller_username;
        this.buyer_realname = buyer_realname;
        this.buyer_phonenumber = buyer_phonenumber;
        this.buyer_address = buyer_address;
        this.buy_sum = buy_sum;
        this.state = state;
        this.create_time = create_time;
        this.finish_time = finish_time;
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
                "order_id=" + order_id +
                ", item_id=" + item_id +
                ", seller_username='" + seller_username + '\'' +
                ", buyer_username='" + buyer_username + '\'' +
                ", buyer_realname='" + buyer_realname + '\'' +
                ", buyer_phonenumber='" + buyer_phonenumber + '\'' +
                ", buyer_address='" + buyer_address + '\'' +
                ", buy_sum=" + buy_sum +
                ", state=" + state +
                ", create_time='" + create_time + '\'' +
                ", finish_time='" + finish_time + '\'' +
                '}';
    }
}
