package com.gjjs.gjjs3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil { // 工具类
    public static Star createProxy(BigStar bigStar){
        Star starProxy = (Star) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class}, new InvocationHandler() {
                    @Override // 回调方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 代理干的事情  写在这里  代理干什么事由invoke方法决定
                        // 三个参数
                        //     1 是当前代理对象  2 是当前代理对象调用的方法  3 是当前代理对象调用方法时传入的参数
//                        if (method.getName().equals("sing")){
//                            System.out.println("准备话筒，收钱20万");
//                            return method.invoke(bigStar, args);
//                        }
//                        else if (method.getName().equals("dance")){
//                            System.out.println("准备场地，收钱1000万");
//                            return method.invoke(bigStar, args);
//                        }else {
//                            return method.invoke(bigStar, args);
//                        }
                        // 简化写法
                        if (method.getName().equals("sing")){
                            System.out.println("准备话筒，收钱20万");
                        }
                        else if (method.getName().equals("dance")){
                            System.out.println("准备场地，收钱1000万");
                        }
                        return method.invoke(bigStar, args);
                        // return null;
                    }
                });
        // Proxy.newProxyInstance 返回一个代理对象
        // 三个参数
        //  用于指定一个类加载器 用这个类加载器去加载生成的代理类 一般开发用当前类的类加载器
        //  指定生成的代理长什么样 也就是有哪些方法 接口数组
        //  指定生产的代理对象要干什么事情
        return starProxy;
    }
}
