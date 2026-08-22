package com.itheima1.hello;

import com.itheima1.gaoji8.*;

import java.util.ArrayList;

public class gaoji8 {
    public static void main(String[] args) {
        System.out.println("1 泛型");
        // 概念：定义类、接口、方法时，同时声明了一个或者多个类型变量（如：<E> 建议变量名E用大写）,称为泛型类、泛型接口、泛型方法、它们统称为泛型。
        // 作用：泛型提供了在编译阶段约束所能操作的数据类型，并自动进行检查的能力！这样可以避免强制类型转换，及其可能出现的异常。
        // 本质：把具体的数据类型作为参数传给类型变量


        ArrayList list = new ArrayList<>();
        list.add("hello");
        list.add(123);
        list.add(3.14);
        list.add(new Cat81());

        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i); // 这里只能用object接收 除非强转 而且cat没法强转成string等
            System.out.println(obj);
        }

        System.out.println("---------------");
//        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<>(); // jdk1.7开始 new后面<>里的数据类型可以省略了
        list2.add("hello");
        list2.add("world");
        list2.add("java");
        for (int i = 0; i < list2.size(); i++) {
            String str = list2.get(i); // 这里可以直接用String接收
            System.out.println(str);
        }

        System.out.println();
        System.out.println("2 自定义泛型类");
        // 实际开发中我们自己自定义泛型很少见 都是用人家写好的

        // 单类型变量
        MyArrayList<String> list3 = new MyArrayList<>();
        list3.add("hello");
        list3.add("world");
        list3.add("java");
        System.out.println(list3.get(0));
        System.out.println(list3.get(1));
        System.out.println(list3.get(2));

        // 多个类型变量 实际开发中 最常见
        Myclass<String, Integer> myclass = new Myclass<>();
        myclass.put("hello", 123);
        Myclass<Cat, Integer> myclass1 = new Myclass<>();
        myclass1.put(new Cat(), 123);

        // 泛型变量带继承的 实际开发中 也最常见
        Myclass1<Cat> myclass2 = new Myclass1<>();
        Myclass1<Dog> myclass3 = new Myclass1<>();

        System.out.println();
        System.out.println("3 自定义泛型接口");
        // 场景：系统需要处理学生和老师的数据，需要提供两个功能：保存对象数据；根据名称查询数据；
        // 写法见Data接口 和两个实现类 StudentData和TeacherData，分别处理学生和老师数据

        System.out.println();
        System.out.println("4 泛型方法");
        System.out.println(test("hello"));
        System.out.println(test(123));
        System.out.println(test(3.14));
        System.out.println(test(new Cat()));

        // 需求所有的骑车可以一起参加比赛
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new BMW());
        cars.add(new BENZ());
        go(cars);

        // 下面的两种写法 执行go方法会报错
        ArrayList<BMW> bms = new ArrayList<>();
        bms.add(new BMW());
        bms.add(new BMW());
        // go(bms);
        go1(bms);

        ArrayList<BENZ> bens = new ArrayList<>();
        bens.add(new BENZ());
        bens.add(new BENZ());
        // go(bens);
        go1(bens);

        // 但是还有问题 dog对象也能入
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        go1(dogs);
        // go2(dogs); // 此时要用限定 <T extends Car>

        System.out.println();
        System.out.println("5 通配符 和 泛型方法的上限和下限限定");
        // 还可以改进 因为ArrayList本身就支持泛型 ArrayList<? extends Car> ， 这个不是定义泛型方法了 是直接使用ArrayList的泛型
        // 此时?通配符代表一切类型 extends Car 表示只能继承Car或Car的子类
        // <? extends Car>这种叫泛型的上限限定，表示T必须是Car或Car的子类
        // 还有一种<？ super Car> 这种叫泛型的下限限定，表示T必须是Car或Car的父类，或者说是Car的祖先类

        // 通配符
        // ? ，可以在使用泛型的时候代表一切类型； E T K V 是在定义泛型的时候使用

        // 泛型的上下限：
        // <? extends Car> 这种叫泛型的上限限定，表示T必须是Car或Car的子类
        // <? super Car> 这种叫泛型的下限限定，表示T必须是Car或Car的父类，或者说是Car的祖先类

        System.out.println();
        System.out.println("6 泛型擦除和注意事项");
        // 泛型擦除：泛型是工作在编译阶段的，一旦程序编译成class文件，class文件中就不存在泛型了，这就是泛型擦除。
        ArrayList<String> ls = new ArrayList<>();
        ls.add("hello");
        ls.add("world");
        System.out.println(ls.get(0)); // 如上代码编译后的class文件 不要用idea和cmd反编译 最准的反编译是工具 用Xjad工具 这里就不安装了。
        // 使用方法也是class文件 直接拖进工具即可 此时看到反编译后的原始代码没有泛型

        // 泛型不支持基本数据类型，只能支持对象类型（引用数据类型）。
        // ArrayList<int> list4 = new ArrayList<>(); // 这里会报错 解决方案是使用包装类Integer
        ArrayList<Integer> list5 = new ArrayList<>();



    }

    // 泛型方法
    public static <T> T test(T t) {
        return t;
    }

    // 需求所有的骑车可以一起参加比赛
    public static void go(ArrayList<Car> cars) {

    }
    public static <T> void go1(ArrayList<T> cars) {

    }
    public static <T extends Car> void go2(ArrayList<T> cars) { // 定义泛型方法

    }
    public static void go3(ArrayList<? extends Car> cars) { // 非泛型方法 使用ArrayList的泛型

    }

}
class Cat81{}































