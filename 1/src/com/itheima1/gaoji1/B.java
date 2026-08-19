package com.itheima1.gaoji1;

// 子类
public class B extends A{
    public int k;

    // 子类继承父类的非私有成员
    public void print3(){
        System.out.println(i);
        print1();

//        System.out.println(j);
//        print2();
    }

}
