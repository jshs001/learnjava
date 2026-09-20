package com.gjjs.gjjs0;


import org.junit.*;

public class StringUtilTest {
// 测试类，用于测试StringUtil类中的方法

    @BeforeClass
    public static void test3(){
        System.out.println("----->test3 BeforeClass 执行了----------");
    }
    
    @AfterClass
    public static void test4(){
        System.out.println("----->test4 AfterClass 执行了----------");
    }


    @Before
    public void test1(){
        System.out.println("----->test1 Before 执行了----------");
    }
    @After
    public void test2(){
        System.out.println("----->test2 After 执行了----------");
    }


    @Test   //写完Test注解后 alt+enter 选择junit4导入即可
    public void testPrintNumber() {
        System.out.println("测试开始");
        StringUtil.printNumber("张三");
        StringUtil.printNumber(null);
        System.out.println("测试结束");
        // 测试一定要测试极端情况 如null等
        // 测试代码好写 但是测试的好不好 需要水平
    }

    @Test
    public void testGetMaxIndex() {
        System.out.println("测试开始");
        int index = StringUtil.getMaxIndex(null);
        System.out.println(index);

        int index1 = StringUtil.getMaxIndex("admin");
        System.out.println(index1);

        // 断言机制： 程序员可以断言预测业务结果
        Assert.assertEquals("方法内部有bug",4,index1);

        System.out.println("测试结束");
    }


}
