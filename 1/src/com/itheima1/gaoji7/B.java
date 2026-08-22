package com.itheima1.gaoji7;

// 扩展 抽象枚举
public enum B {
    X(){
        @Override
        public void go() {
            System.out.println("X go");
        }  // 这里类似匿名内部类的写法 但是没有new
    },
    Y(){
        @Override
        public void go() {
            System.out.println("Y go");
        }
    },
    Z("张三"){
        @Override
        public void go() {
            System.out.println("Z go:"+getName());
        }
    };

    private String name; // 还可以写其他成员

    public abstract void go(); // 加个抽象方法

    B() {  // 默认私有
    }

    B(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
