package com.shop.entity;

public class User {
    private String username;
    private String password;
    private String nickname;
    private int permission;
    private String phonenumber;
    private String address;
    private String realname;
    private String user_head;

    public User() {
        super();
    }

    public User(String username, String password, String nickname, int permission, String phonenumber, String address, String realname, String user_head) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.permission = permission;
        this.phonenumber = phonenumber;
        this.address = address;
        this.realname = realname;
        this.user_head = user_head;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickname;
    }

    public void setNickName(String nick_name) {
        this.nickname = nick_name;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUserHead() {
        return user_head;
    }

    public void setUserHead(String user_head) {
        this.user_head = user_head;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", permission=" + permission +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                ", realname='" + realname + '\'' +
                ", user_head='" + user_head + '\'' +
                '}';
    }
}
