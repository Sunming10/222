package entity;

import java.util.Objects;

public class Goods {
    private Long item_id;
    private String goods_name;
    private String seller_id;
    private Long goods_number;
    private Long goods_price;
    private String goods_img;
    private String goods_discribe;
    private int goods_state;

    public Goods() {
        super();
    }

    public Goods(Long item_id, String goods_name, String seller_id, Long goods_number, Long goods_price, String goods_img, String goods_discribe, int goods_state) {
        this.item_id = item_id;
        this.goods_name = goods_name;
        this.seller_id = seller_id;
        this.goods_number = goods_number;
        this.goods_price = goods_price;
        this.goods_img = goods_img;
        this.goods_discribe = goods_discribe;
        this.goods_state = goods_state;
    }

    public Goods(Long item_id, String goods_name, String seller_id, Long goods_number, String goods_img, String goods_discribe, int goods_state) {
        this.item_id = item_id;
        this.goods_name = goods_name;
        this.seller_id = seller_id;
        this.goods_number = goods_number;
        this.goods_img = goods_img;
        this.goods_discribe = goods_discribe;
        this.goods_state = goods_state;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public Long getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(Long goods_number) {
        this.goods_number = goods_number;
    }

    public Long getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Long goods_price) {
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
                ", seller_id='" + seller_id + '\'' +
                ", goods_number=" + goods_number +
                ", goods_price=" + goods_price +
                ", goods_img='" + goods_img + '\'' +
                ", goods_discribe='" + goods_discribe + '\'' +
                ", goods_state=" + goods_state +
                '}';
    }
}
