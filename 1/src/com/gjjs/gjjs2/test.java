package com.gjjs.gjjs2;

@MyTest1(aaa="牛魔王", bbb=false, ccc={"a", "b", "c"})
//@MyTest2( value = "测试")
@MyTest2("测试")
@MyTest3("测试")
public class test {


    @MyTest1(aaa="公主", bbb=false, ccc={"a", "b", "c"})
    // @MyTest3("测试") // 这里就用不了
    public void test() {
    }

    public static void main(String[] args) {

    }

}
