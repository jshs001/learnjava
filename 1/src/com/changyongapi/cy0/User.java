package com.changyongapi.cy0;

// Cloneable接口：标记接口，让类实现Cloneable接口，表示该类的实例可以被克隆
public class User implements Cloneable {
    private int id;
    private String username;
    private String password;
    private double[] scores;

    public User() {
    }
    public User(int id, String username, String password, double[] scores) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.scores = scores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    @Override // clone 回车即可创建
    public Object clone() throws CloneNotSupportedException {
        // return super.clone(); // 浅克隆
        return new User(this.id, this.username, this.password, this.scores.clone()); // 深克隆 需要把scores数组也克隆
    }
}
