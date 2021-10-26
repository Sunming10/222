package com.shop.entity;

public class GO {
    private int GO_id;
    private int item_id;
    private int order_id;

    public int getGO_id() {
        return GO_id;
    }

    public void setGO_id(int GO_id) {
        this.GO_id = GO_id;
    }

    public GO(int GO_id, int item_id, int order_id) {
        this.GO_id = GO_id;
        this.item_id = item_id;
        this.order_id = order_id;
    }

    public GO() {
    }

    public GO(int item_id, int order_id) {
        this.item_id = item_id;
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "GO{" +
                "GO_id=" + GO_id +
                ", item_id=" + item_id +
                ", order_id=" + order_id +
                '}';
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
