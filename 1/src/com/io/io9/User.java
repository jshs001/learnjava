package com.io.io9;

import java.io.Serializable;

public class User implements Serializable {
    private String loginName;
    private String userName;
    private int age;
    // transient 关键字：表示这个成员变量 不会被序列化
    private transient String password;

    public User() {
    }
    public User(String loginName, String userName, int age, String password) {
        this.loginName = loginName;
        this.userName = userName;
        this.age = age;
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
