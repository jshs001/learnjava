package com.collection.hello;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jh3 {
    public static void main(String[] args) {
        System.out.println("1 Collection使用场景总结");
        // 1、如果希望记住元素的添加顺序，需要存储重复的元素，又要频繁的根据索引查询数据?
        // 用ArrayList集合(有序、可重复、有索引)，底层基于数组的。(常用)

        // 2、如果希望记住元素的添加顺序，且增删首尾数据的情况较多?
        // 用LinkedList集合(有序、可重复、有索引)，底层基于双链表实现的。

        // 3.如果不在意元素顺序，也没有重复元素需要存储，只希望增删改查都快?
        // 用Hashset集合(无序，不重复，无索引)，底层基于哈希表实现的。(常用)

        // 4.如果希望记住元素的添加顺序，也没有重复元素需要存储，且希望增删改查都快?
        // 用LinkedHashSet集合(有序，不重复，无索引)，底层基于哈希表和双链表

        // 5.如果要对元素进行排序，也没有重复元素需要存储?且希望增删改查都快?
        // 用Treeset集合，基于红黑树实现。

        System.out.println();
        System.out.println("2 集合的并发修改异常");
        // 集合的并发修改异常：如使用迭代器遍历集合时，又同时在删除集合中的数据，程序就会出现并发修改异常的错误
        List<String> list = new ArrayList<>();
        list.add("王麻子");
        list.add("小李子");
        list.add("李爱花");
        list.add("张无忌");
        list.add("小李");
        list.add("李玉刚");
        System.out.println(list);


        // 需求：找出集合中带“李”的元素 并从集合中删除
        // 如下代码会报错 此处报错就是因为使用了迭代器遍历集合时，又同时在删除集合中的数据，程序就会出现并发修改异常的错误
        // 类似下面for循环出现的bug
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            String s = it.next();
//            if (s.contains("李")) {
//                list.remove(s);
//            }
//        }
//
//        System.out.println(list);


        // for循环实现 发现问题 李没删干净 是因为每删除一次元素 后面元素就往前进1 所以出现了跳过的bug
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).contains("李")) {
//                list.remove(i);
//            }
//        }
//        System.out.println(list);


        // 解决方案
//        for (int i = 0; i < list.size(); i++) { // i-- 或者倒着循环
//            if (list.get(i).contains("李")) {
//                list.remove(i);
//                i--; // 删除元素后索引位置会变，所以这里要减1
//            }
//        }
//        System.out.println(list);

//        for (int i = list.size()-1; i >= 0; i--) {
//            if (list.get(i).contains("李")) {
//                list.remove(i);
//            }
//        }
//        System.out.println(list);

//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            String s = it.next();
//            if (s.contains("李")) {
////                list.remove(s);  // 并发修改异常错误
//                it.remove(); // 删除迭代器当前遍历到的数据，并且每删除一个数据后，相当于也在底层做了i--
//            }
//        }
//        System.out.println(list);


        // 注意 使用增强for循环遍历集合并删除数据， 没办法解决bug
//        for (String s : list) {
//            if (s.contains("李")) {
//                list.remove(s);
//            }
//        }
//        System.out.println(list);

        // 注意 lambda 底层就是增强for 循环遍历集合并删除数据， 没办法解决bug
//        list.forEach(s -> {
//            if (s.contains("李")) {
//                list.remove(s);
//            }
//        });
//        System.out.println(list);



        // 总结：

        // 集合的并发修改异常
        // 使用迭代器遍历集合时，又同时在删除集合中的数据，程序就会出现并发修改异常的错误，
        // 由于增强for循环遍历集合就是迭代器遍历集合的简化写法，因此，使用增强for循环遍历集合，又在同时删除集合中的数据时，程序也会出现并发修改异常的错误

        // 怎么保证遍历集合同时删除数据时不出bug?
        // 使用迭代器遍历集合，但用迭代器自己的删除方法删除数据即可
        // 如果能用for循环遍历时:可以倒着遍历并删除;或者从前往后遍历，但删除元素后做i --操作。
    }
}






















