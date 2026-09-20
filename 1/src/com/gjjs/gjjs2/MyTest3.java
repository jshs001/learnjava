package com.gjjs.gjjs2;

// 自定义注解

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 注解的使用范围 此处表示只能用在类上
@Retention(RetentionPolicy.RUNTIME) // 注解的保留策略 此处表示运行时保留
public @interface MyTest3 {
    String value(); // 特殊属性
}
