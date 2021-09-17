package com.wql.pojo;

public class User {
    private String id;//用户名
    private String name;//姓名
    private String tel;//电话
    private String password;//密码
    private int state;//状态

    public User(){

    }

    public User(String id, String name, String tel, String password, int state) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.password = password;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
