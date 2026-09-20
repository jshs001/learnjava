package com.gjjs.gjjs3;

import java.lang.reflect.Proxy;

public class UserServiceImpl implements UserService{
    @Override
    public void login(String loginName, String passWord) throws Exception {
        if("admin".equals(loginName) && "123456".equals(passWord))
            System.out.println("登录成功");
        else
            System.out.println("登录失败");
        Thread.sleep(1000);
    }

    @Override
    public void deleteUsers() throws Exception {
        System.out.println("成功删除了10000个用户");
        Thread.sleep(1500);
    }

    @Override
    public String[] selectUsers() throws Exception {
        System.out.println("查询出了3个用户");
        Thread.sleep(500);
        return new String[]{"张三", "李四", "王五"};
    }
}
