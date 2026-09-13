package com.collection.hello;

import java.util.*;

public class jh5 {
    public static void main(String[] args) {
        System.out.println("1 Map集合");
        // Map集合:双列集合，格式为：{key1=value1 key2=value2 ...}，一次要存一对数据作为一个元素
        // Map集合的每个元素"key=value"称为一个键值对/键值对对象/一个entry对象，map集合也被叫做“键值对集合”
        // Map集合的所有键是不允许重复的，但是值可以重复，键和值是一一对应的，每个键只能找到自己的体系

        // Map（接口） 体系结构
        // 注意：Map系列集合的特点都是由键决定的，值只是一个附属品，值是不做要求的。
        // Map
        //      HashMap（由键决定的特点）：无序、不重复、无索引；（用的最多）
        //          LinkedHashMap（由键决定的特点）：有序、不重复、无索引
        //      TreeMap（由键决定的特点）：排序（按照键的大小默认升序排序）、不重复、无索引

//        Map<String, Integer> map = new HashMap<>(); // 这是一行经典代码
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("张三", 18);
        map.put("李四", 19);
        map.put("李四", 18); // 后面的重复数据会覆盖前面的
        map.put("王五", 20);
        map.put(null, null); // 无序
        System.out.println(map);

        Map<Integer, String > map1 = new TreeMap<>();
        map1.put(11, "张三");
        map1.put(2, "李四");
        map1.put(3, "王五");
        System.out.println(map1);

        System.out.println();
        System.out.println("2 Map集合的常用方法");
        System.out.println("map.size():" + map.size()); // 获取map集合的大小
        // map.clear();// 清空map集合
        System.out.println("map.isEmpty():" + map.isEmpty()); // 判断map集合是否为空
        System.out.println("map.get(\"张三\"):" + map.get("张三")); // 获取指定键对应的值
        System.out.println("map.remove(\"张三\"):" + map.remove("张三")); // 删除指定键对应的键值对
        System.out.println(map);
        System.out.println("map.containsKey(\"张三\"):" + map.containsKey("张三")); // 判断map集合中是否包含指定的键
        System.out.println("map.containsValue(18):" + map.containsValue(18)); // 判断map集合中是否包含指定的值
        System.out.println("map.keySet():" + map.keySet()); // 获取map集合中所有的键 返回的是一一个Set集合
        System.out.println("map.values():" + map.values()); // 获取map集合中所有的值 返回的是一一个Collection集合
        System.out.println("map.entrySet():" + map.entrySet()); // 获取map集合中所有的键值对 返回的是一一个Set集合

        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("老6", 18);
        map2.put("呕7", 19);
        map.putAll(map2); // 将map2中的所有键值对添加到map中
        System.out.println(map);
        System.out.println("map2:" + map2);

        System.out.println();
        System.out.println("3 Map集合的遍历");
        // 三种方式 1键找值
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        // 三种方式 2键值对
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // 三种方式 3 jdk1.8开始支持 lambda表达式
        map.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println();
        System.out.println("4 Map集合的案例");
        // 统计80个学生选择的景点
        List<String> list = new ArrayList<>();
        String[] select = {"A", "B", "C", "D"};
        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            int index = random.nextInt(select.length);
            list.add(select[index]);
        }
        System.out.println(list);

        Map<String, Integer> map3 = new HashMap<>();
        for (String s : list) {
            if (map3.containsKey(s)) {
                int count = map3.get(s);
                map3.put(s, count + 1);
            } else {
                map3.put(s, 1);
            }
        }
        System.out.println(map3);

        // 需要存储一一对应的数据时，就可以考虑使用Map集合







    }
}



















