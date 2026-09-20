package com.gjjs.gjjs2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 该注解只能用在方法上
@Retention(RetentionPolicy.RUNTIME) // 该注解在运行时保留
public @interface MyTest {


}
