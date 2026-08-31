package com.changyongapi.hello;

import com.changyongapi.cy5.Student;
import com.changyongapi.cy7.Car;
import com.changyongapi.cy7.CompareByData;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class cy7 {
    public static void main(String[] args) {
        System.out.println("1 静态方法引用");
        // 1 静态方法引用：  类名::静态方法名
        // 使用场景：如果某个lambda表达式只是调用一个静态方法，并且前后参数的形式一样， 就可以使用静态方法引用
        Student[] students = new Student[4];
        students[0] = new Student("张三", 179.5, 18);
        students[1] = new Student("李四", 160.5, 19);
        students[2] = new Student("王五", 191.5, 20);
        students[3] = new Student("赵六", 182.5, 21);
        // Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge()); // 简化为
        // Arrays.sort(students, (o1, o2) -> CompareByData.compareByAge(o1, o2 )); // 简化为
        Arrays.sort(students, CompareByData::compareByAge);
        System.out.println(Arrays.toString(students));

        System.out.println();
        System.out.println("2 实例方法引用");
        // 实例方法引用：  对象名::实例方法名
        // 使用场景：如果某个lambda表达式只是调用一个对象的实例方法，并且前后参数的形式一样， 就可以使用实例方法引用
        // Arrays.sort(students, (o1, o2) -> o2.getAge() - o1.getAge()); // 简化为
        CompareByData compare = new CompareByData();
        // Arrays.sort(students, (o1, o2) -> compare.compareByAge1(o1, o2) ); // 简化为
        Arrays.sort(students, compare::compareByAge1);
        System.out.println(Arrays.toString(students));

        System.out.println();
        System.out.println("3 特定类型方法引用");
        // 特定类型方法引用：  类名::方法
        // 使用场景：如果某个lambda表达式只是调用一个实例方法，并且前面参数列表中的第一个参数是作为方法的主调，后面的所有参数都是作为该实例的方法的入参的，则此时就可用特定类型的方法引用
        String[] names = {"Andy", "boby", "aici", "capcao", "Bavid"};
//        Arrays.sort(names);

        // 需求默认是安装首字母的编号进行升序排序的 此时要求忽略首字母大小写
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareToIgnoreCase(o2);
//            }
//        }); // 简化为
//        Arrays.sort(names, (o1, o2) -> o1.compareToIgnoreCase(o2)); // 简化为
        Arrays.sort(names, String::compareToIgnoreCase);


        System.out.println(Arrays.toString(names));

        System.out.println();
        System.out.println("4 构造器引用");
        // 构造器引用：  类名::new
        // 使用场景：如果某个lambda表达式只是在创建对象，并且前后参数情况一致，则可以使用构造器引用
//        CreateCar cc = new CreateCar() {
//            @Override
//            public Car createCar(String name, double price) {
//                return new Car(name, price);
//            }
//        }; // 简化为
//        CreateCar cc = (name, price) -> new Car(name, price);
        CreateCar cc = Car::new;
        Car car = cc.createCar("奥迪", 30.0);
        System.out.println(car.getName() + " " + car.getPrice());

    }
}

interface CreateCar{
    Car createCar(String name, double price );
}