package com.itheima.hello;

public class rumen4 {
    public static void main(String[] args) {
        System.out.println("1 方法概述：就是一段代码 封装成方法 重复使用");
        // 方法定义格式： 修饰符 返回值类型 方法名(参数列表){方法体}
        // 调用方法格式： 方法名(参数列表)

        // 注意：
        // 如果有放回类型 必须return 来返回数据。且return语句下面 不要写代码，因为return语句会结束方法体
        // 形参列表可以有多个，也可没有，多个用逗号隔开。
        // 设计方法 如果没有返回参数 那么返回参数类型要写 void
        // 如果方法不需要入参 怎方法定义时候形参保持()就行
        // 方法不要写在main方法里面 可以写在main方法前或后
        // 调用方法必然满足方法的形参情况
        // 调用有返回值的方法 可以 1 可以定义变量接收结果； 2 或直接输出调用 ；3 或直接调用
        // 调用无返回值的方法 只能直接调用

        // 求和案例
        System.out.println(sum(1, 2));

        // 求1-n的和
        System.out.println(sum(5));

        // 判断一个数字 是奇数还是偶数
        isOdd(5);

        System.out.println("2 java的参数传递机制");
        // 值传递： 分基本数据类型参数传递 引用数据类型参数传递；
        // 所谓值传递 就是在传输实参给方法的形参的时候，传输的是实参变量中存储的值的副本。
        // 实参是调用时候的参数，形参是方法定义时候的参数。

        // 基本类型参数传递案例
        int a = 10;
        change(a); // 20 change方法内部作用域的a 变成了20
        System.out.println("main的值是：" +a); // 10 main函数作用域中的a 仍然还是10

        // 引用类型参数传递案例
        int[] arrs = new int[]{1,2,3,4,5};
        changed(arrs); // 20
        System.out.println("main：" + arrs[0]); // 20 引用类型参数传递的是对象地址 地址一样就是一个对象 调用函数执行时对象改变了 所以mian中的arrs[0]也变成了20

        System.out.println("3 参数传递案例");
        // 其他参数传递案例: 打印int类型的数组内容
        printArray(arrs);

        // 比较两个int类型的数组是否一样，返回ture或false
        int[] arr1 = null;
        int[] arr2 = new int[]{20,2,3,4,5};
        System.out.println(compareArray(arrs, arr2));

        System.out.println("4 方法重载：一个类中 出现多个方法名相同，但形参列表不同，这些方法就是方法重载");
        // 一个类中 只要方法名称相同 形参列表不同 就是方法重载了 其他不管 如修饰符 返回值类型是否一样等
        // 形参列表不同是指 形参的个数、类型、顺序不同 不用关心形参的名称

        // 场景：处理一类业务，提供多种解决方案，此时用方法重载来设计是非常专业的。
        // 如开发一个武器系统 默认发一枚武器 或指定地区发射一枚武器 或知道地区发射多枚武器
        // Java的api中很多方法都是方法重载

        // 方法重载案例 发射武器
        fire();
        fire("北京");
        fire(5,"上海");

        System.out.println("5 return可以用在无返回值的方法中，作用是立即跳出并结束当前方法的执行");
        divide(17,2);
        divide(17,0);

    }


    public static int sum(int a, int b) {
        int c = a + b;
        return c;
    }
    public static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    public static void isOdd(int n) {
        if (n % 2 == 0) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }
    }

    public static void change(int a) {
        System.out.println("change1的值是：" +a);
        a = 20;
        System.out.println("change2的值是：" +a);
    }

    public static void changed(int[] arr) {
        System.out.println("方法内1：" +arr[0]);
        arr[0] = 20;
        System.out.println("方法内2：" +arr[0]);
    }
    public static void printArray(int[] arr) { // 这里有一个bug  int[] arr = null  传进来就会报错空指针
        if (arr == null) {
            System.out.println(arr);
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }
    public static boolean compareArray(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length ; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void fire(){
        System.out.println("默认发射了一枚武器");
    }
    public static void fire(String area){
        System.out.println("发射武器到" + area);
    }
    public static void fire(int count,String area){
        System.out.println("发射" + count + "枚武器到" + area );
    }

    // 做一个无返回值除法函数的demo 用到return 处理除数是0的问题
    public static void divide(int a, int b) {
        if (b == 0) {
            System.out.println("除数不能为0");
            return;
        }
        System.out.println(a / b);
    }
}














