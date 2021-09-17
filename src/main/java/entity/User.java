package entity;

public class User {
    private String user_id;
    private String password;
    private String nick_name;
    private int permission;
    private String phonenumber;
    private String address;
    private String realname;
    private String user_head;

    public User() {
        super();
    }

    public User(String user_id, String password, String nick_name, int permission, String phonenumber, String address, String realname, String user_head) {
        this.user_id = user_id;
        this.password = password;
        this.nick_name = nick_name;
        this.permission = permission;
        this.phonenumber = phonenumber;
        this.address = address;
        this.realname = realname;
        this.user_head = user_head;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
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

    public String getUser_head() {
        return user_head;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", password='" + password + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", permission=" + permission +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                ", realname='" + realname + '\'' +
                ", user_head='" + user_head + '\'' +
                '}';
    }
}
