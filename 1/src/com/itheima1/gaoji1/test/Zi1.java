package com.itheima1.gaoji1.test;

import com.itheima1.gaoji1.Fu;

public class Zi1 extends Fu {
    public void test() {
        // privateMethod(); // 私有方法不能被非同包子类调用
        // defaultMethod(); // 默认方法不能被非同包子类调用
        protectedMethod(); // 保护方法可以被子类调用
        publicMethod(); // 公共方法可以被子类调用
    }
}
