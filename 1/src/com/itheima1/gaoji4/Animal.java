package com.itheima1.gaoji4;

public abstract class Animal {
    private String name;

    public abstract void cry(
    );

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
