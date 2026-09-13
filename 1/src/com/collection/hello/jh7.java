package com.collection.hello;

import com.collection.jh6.Student;
import com.collection.jh6.Student1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class jh7 {
    public static void main(String[] args) {
        System.out.println("1 Stream");
        // Stream流：jdk8新增api，可以用于操作集合或者数组的数据；
        // 优势：大量结合Lambda表达式，代码简洁，易读；

        List<String> names = new ArrayList<>();
        Collections.addAll(names, "张三丰", "张无忌", "周芷若", "赵敏", "周芷若", "张强");

        // 传统方法
        List<String> list = new ArrayList<>();
        for (String name : names){
            if (name.length() == 3 && name.startsWith("张")){
                list.add(name);
            }
        }
        System.out.println(list);

        // Stream流 支持链式编程
        List<String> list1 = names.stream().filter(s -> s.length() == 3 && s.startsWith("张")).collect(Collectors.toList());
        System.out.println(list1);

        // Stream流使用步骤
        // 1 获取数据源 集合、数组
        // 2 中间操作 过滤 排序 去重...
        // 3 获取处理的结果 遍历、统计、收集到新的集合中返回

        System.out.println();
        System.out.println("2 获取Stream流");
        // 1 获取Stream流
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "刘德华", "张曼玉", "蜘蛛精", "马德", "德玛西亚");

        Map<String, Double> map = new HashMap<>();
        map.put("古力娜扎", 172.3);
        map.put("迪丽热巴", 168.3);
        map.put("马尔扎哈", 166.3);
        map.put("卡尔扎巴", 168.3);

        String[] names1 = {"张翠山", "东方不败", "唐大嫂", "独孤求败"};

        // Collection获取Stream流
        Stream<String> stream = names.stream();
        Stream<String> stream1 = set.stream();
        stream1.filter(s-> s.contains("德")).forEach(s-> System.out.println(s));

        // Map获取Stream流
        Set<String> keySet = map.keySet(); // 获取键流
        Stream<String> stream2 = keySet.stream();

        Collection<Double> values = map.values(); // 获取值流
        Stream<Double> stream3 = values.stream();

        Set<Map.Entry<String, Double>> entries = map.entrySet(); // 获取键值对流
        Stream<Map.Entry<String, Double>> stream4 = entries.stream();
        stream4.filter(e -> e.getKey().contains("巴")).forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        // Arrays数组获取Stream流
        Stream<String> stream5 = Arrays.stream(names1);
        Stream<String> stream6 = Stream.of(names1);

        System.out.println();
        System.out.println("3 Stream流常用方法");
        // Stream流常见中间方法：调用完成后会返回一个新的Stream流，可以继续调用其他方法（支持链式编程）
        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores, 88.5, 90.0, 78.5, 92.0, 85.0);
        scores.stream().filter(s -> s >= 80).sorted().forEach(s -> System.out.println(s)); // 60 85 88.5 90 92

        List<Student> students = new ArrayList<>();
        Student s1 = new Student("张三", 18, 175.5);
        Student s2 = new Student("李四", 19, 180.5);
        Student s3 = new Student("王五", 20, 170.5);
        Student s4 = new Student("赵六", 21, 165.5);
        Student s5 = new Student("孙七", 22, 160.5);
        Student s6 = new Student("周八", 24, 168.5);
        Student s7 = new Student("周八", 24, 168.5);
        Collections.addAll(students, s1, s2, s3, s4, s5, s6, s7);

        students.stream().filter(s -> s.getAge() >= 20 && s.getAge() <= 23).sorted((o1, o2) -> o2.getAge() - o1.getAge()).forEach(s -> System.out.println(s));
        System.out.println();
        students.stream().sorted((o1, o2) -> Double.compare(o2.getHeight(), o1.getHeight())).limit(3).forEach(s -> System.out.println(s));
        System.out.println();
        students.stream().sorted((o1, o2) -> Double.compare(o2.getHeight(), o1.getHeight())).skip(students.size() - 2).forEach(s -> System.out.println(s));
        System.out.println();
        students.stream().filter(s -> s.getHeight() > 168).map(s -> s.getName()).distinct().forEach(s -> System.out.println(s));


        List<Student1> students1 = new ArrayList<>();
        Student1 s11 = new Student1("张三", 18, 175.5);
        Student1 s12 = new Student1("李四", 19, 180.5);
        Student1 s13 = new Student1("王五", 20, 170.5);
        Student1 s14 = new Student1("赵六", 21, 165.5);
        Student1 s15 = new Student1("孙七", 22, 160.5);
        Student1 s16 = new Student1("周八", 24, 168.5);
        Student1 s17 = new Student1("周八", 24, 168.5);
        Collections.addAll(students1, s11, s12, s13, s14, s15, s16, s17);

        System.out.println();
        students.stream().filter(s -> s.getHeight() > 168).distinct().forEach(s -> System.out.println(s));

        System.out.println(); // distinct 去重   需要类定义中重写equals和hashCode方法
        students1.stream().filter(s -> s.getHeight() > 168).distinct().forEach(s -> System.out.println(s));

        System.out.println(); // concat 合并两个Stream流为一个流
        Stream<String> st1 = Stream.of("张三", "李四", "王五");
        Stream<String> st2 = Stream.of("张三2", "李四3", "王五5");
        Stream<String> allSt = Stream.concat(st1, st2);
        allSt.forEach(s -> System.out.println(s));

        System.out.println();
        System.out.println("4 Stream流常用终端方法");
        // 终结方法是指调用完成后，不会返回新的Stream了，没法继续使用流了。
        students1.stream().filter(s -> s.getHeight() > 168).distinct().forEach(s -> System.out.println(s));
        System.out.println();
        long size = students1.stream().filter(s -> s.getHeight() > 168).distinct().count();
        System.out.println("数量：" + size);
        System.out.println();
        Student1 ss = students1.stream().max((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight())).get();
        System.out.println("最大身高：" + ss.getName() + " : " + ss.getHeight());

        System.out.println();
        Student1 ss1 = students1.stream().min((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight())).get();
        System.out.println("最小身高：" + ss1.getName() + " : " + ss1.getHeight());

        // 除了以上几种还有一种终端方法：收集Steam流，就是把Stream流收集到一个集合或数组中返回
        // Stream流是方便操作集合/数组的手段；集合/数组：才是开发中的目的；
        Stream<Student1> studentSteam = students1.stream().filter(s -> s.getHeight() > 170).distinct();
        Stream<Student1> studentSteam1 = students1.stream().filter(s -> s.getHeight() > 170).distinct();
        System.out.println();
        List<Student1> list2 = studentSteam.collect(Collectors.toList()); // 收集到List中
        System.out.println(list2);

        System.out.println();
//        Set<Student1> set2 = studentSteam.collect(Collectors.toSet()); // 收集到Set中 // 这里会报错 因为流只能收集一次
        Set<Student1> set2 = studentSteam1.collect(Collectors.toSet()); // 收集到Set中 // 这里会报错 因为流只能收集一次
        System.out.println(set2);

        Map<String, Double> map2 = students1.stream().filter(s -> s.getHeight() > 170).distinct().collect(Collectors.toMap(Student1::getName, Student1::getHeight)); // 收集到Map中
        System.out.println(map2);

        System.out.println();
        Object[] array = students1.stream().filter(s -> s.getHeight() > 170).distinct().toArray(); // 收集到数组中
        Student1[] array1 = students1.stream().filter(s -> s.getHeight() > 170).distinct().toArray(len -> new Student1[len]); // 收集到Student1数组中
        System.out.println(Arrays.toString(array1));

    }
}






































