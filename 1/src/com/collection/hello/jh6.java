package com.collection.hello;

import com.collection.jh6.Student;
import com.collection.jh6.Student1;

import java.util.*;

public class jh6 {
    public static void main(String[] args) {
        System.out.println("1 HashMap");
        // HashMap集合的底层原理：跟HashSet的底层原理一样，都是基于哈希表实现的。
        // 实际上，Set系列集合的底层就是基于Map实现的，只是Set集合中的元素只要键数据，不要值数据而已。

        // 哈希表：jdk8之前，数据+链表；jdk8之后，数据+链表+红黑树；是一种增删改查性能都较好的数据结构。
        // 键是无序、不重复、无索引的
        // HashMap的键依赖hasCode方法和equals方法保证键唯一
        // 如果键存储的是自定义类型的对象，可以通过重写hashCode方法和equals方法,这样可以保证多个对象内容一样时，HashMap认为是重复的

        Map<Student, String> map = new HashMap<>();
        map.put(new Student("蜘蛛精",25,165.5), "妖");
        map.put(new Student("蜘蛛精",25,165.5), "妖");
        map.put(new Student("孙悟空",20,180.5), "仙");
        map.put(new Student("猪八戒",22,170.5), "妖");
        System.out.println(map);

        // 下面的代码中，键是Student1类型，重写了hashCode方法和equals方法，所以键蜘蛛精被认为是重复的
        Map<Student1, String> map1 = new HashMap<>();
        map1.put(new Student1("蜘蛛精",25,165.5), "妖");
        map1.put(new Student1("蜘蛛精",25,165.5), "妖");
        map1.put(new Student1("孙悟空",20,180.5), "仙");
        map1.put(new Student1("猪八戒",22,170.5), "妖");
        System.out.println(map1);


        System.out.println();
        System.out.println("2 LinkedHashMap");
        // 底层数据结构依然是基于哈希表实现的，只是每个键值对元素额外多了一个双链表机制，记录元素顺序
        // 实际上LinkedHashSet集合的底层原理就是LinkedHashMap

        System.out.println();
        System.out.println("3 TreeMap");
        // TreeMap跟TreeSet集合的底层原理一样，都是基于红黑树实现的排序

        // TreeMap集合同样支持两种方法来指定排序规则
        // 让类实现Comparable接口，重写比较规则
        // TreeMap集合有参构造器，支持创建Comparator比较器对象，从而指定排序规则(优先级高)
//        Map<Student, String> map2 = new TreeMap<>();
        Map<Student, String> map2 = new TreeMap<>((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight())) ;
        map2.put(new Student("蜘蛛精",25,165.5), "妖");
        map2.put(new Student("孙悟空",20,180.5), "仙");
        map2.put(new Student("猪八戒",22,170.5), "妖");
        System.out.println(map2);

        System.out.println();
        System.out.println("4 Map集合的嵌套");
        Map<String, List<String>> map3 = new HashMap<>();
        map3.put("班级1", new ArrayList<>(Arrays.asList("张三", "李四", "王五")))   ;
        map3.put("班级2", new ArrayList<>(Arrays.asList("赵六", "孙七", "周八")));
        map3.put("班级3", new ArrayList<>(Arrays.asList("吴九", "郑十", "王十一")));
        System.out.println(map3);

        List<String> list = map3.get("班级1");
        for (String s : list)
            System.out.println(s);

        map3.forEach((key, value) -> System.out.println(key + " : " + value));





    }
}












