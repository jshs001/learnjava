package com.gjjs.gjjs2;

// 自定义注解


public @interface MyTest1 {
    String aaa();
    boolean bbb() default true;
    String[] ccc() default {"a", "b", "c"};
}
