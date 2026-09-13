package com.collection.hello;

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
        



    }
}










