package com.gjjs.hello;

import com.gjjs.gjjs3.*;
import com.itheima1.gaoji7.B;

import java.util.Arrays;

public class gjjs3 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 动态代理");
        // 动态代理：对象如果嫌身上干的事太多的话，可以通过代理转移部分职责
        // 代理：就是让第三者代替自己做某件事

        BigStar bigStar = new BigStar("杨超越");
        Star sp = ProxyUtil.createProxy(bigStar); // 代理对象
        String rs = sp.sing("小幸运");
        System.out.println(rs);
        System.out.println();
        sp.dance();

        System.out.println();
        System.out.println("2 案例");

//        UserService userService = new UserServiceImpl();
        UserService userService = ProxyUtil1.createProxy(new UserServiceImpl()); // 只需要换代理对象

        userService.login("admin", "123456");
        System.out.println("----------------------------------------");

        userService.deleteUsers();
        System.out.println("----------------------------------------");

        String[] names = userService.selectUsers();
        System.out.println("查询到的用户是：" + Arrays.toString(names));
        System.out.println("----------------------------------------");

    }
}
