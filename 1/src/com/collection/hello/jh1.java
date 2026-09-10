package com.collection.hello;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class jh1 {
    public static void main(String[] args) {
        System.out.println("1 list 集合特有方法");
        // list集合因为支持索引，所以多了很多与索引相关的方法，当然Collection的功能list都继承了
        List<String> list = new ArrayList<>(); // 一行经典代码
        list.add("蜘蛛精");
        list.add("猪八戒");
        list.add("孙悟空");
        list.add("唐僧");
        System.out.println(list);

        list.add(2,"沙僧"); // 在索引2的位置插入元素"沙僧"
        System.out.println(list);

        System.out.println(list.remove(1)); // 删除索引1位置的元素，并返回该元素
        System.out.println(list);

        System.out.println(list.get(3)); // 获取索引3位置的元素

        System.out.println(list.set(2,"牛魔王")); // 修改索引2位置的元素，并返回该元素
        System.out.println(list);

        System.out.println();
        System.out.println("2 list 集合遍历");
        // 1 for循环
        for (int i = 0; i < list.size(); i++) {  // list.fori
            System.out.println(list.get(i));
        }
        // 2 迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()) { // 判断集合中是否还有元素
            System.out.println(it.next()); // 获取并遍历集合中的元素
        }
        // 3 foreach
        for (String s : list) {  // list.for
            System.out.println(s);
        }
        // 4 lambda
        list.forEach(s -> System.out.println(s));

        System.out.println();
        System.out.println("3 ArrayList");
        // 1 ArrayList集合的底层原理：基于数组实现的。
        // 特点：
        //   查询速度快（注意：根据索引查询数据快）
        //   删除效率低：可能需要把后面很多的数据进行前移，导致删除效率低
        //   添加效率极低：可能需要把后面很多的数据进行后移，再添加元素；或者也可能需要进行数组的扩容；
        // 简化：查询快，增删慢

        // 利用无参构造器创建的集合，会在底层创建一个默认长度为0的数组
        // 添加第一个元素时，底层会创建一个新的长度为10的数组
        // 存满时，再新增元素会扩容1.5倍
        // 如果一次添加多个元素，1，5倍还放不下，则新创建数组的长度以实际为准

        // 2 ArrayList适合的应用场景
        //   适合：根据索引查询数据，比如根据随机索引取数据（高效）或者数据量不是很大时
        //   不适合：数据量大的同时，又要频繁的进行增删操作（低效）

        System.out.println();
        System.out.println("4 LinkedList");
        // 1 LinkedList集合的底层原理：基于双链表实现的。

        // 单向链表：链表中的结点时独立的对象，在内存中时不连续的，每个结点包含数据值和下一个结点的地址。
        // 单向链表特点：
        //   查询效率低，无论查哪个数据，都需要从头开始找。即便根据索引定位，也需要从头开始找。
        //   增删相对快：相对数组而言。因为不需要移动元素。而且不存在扩容问题。

        // 双向链表：链表中的结点时独立的对象，在内存中时不连续的，每个结点包含数据值和下一个结点的地址以及上一个结点的地址。
        // 双向链表特点：查询慢，增删相对较快，但对首尾元素进行增删改查的速度是极快的。

        // LinkedList特点：查询慢，增删相对较快，但对首尾元素进行增删改查的速度是极快的。
        // LinkedList新增了很多首尾操作的特有方法。

        // 2 LinkedList适合的应用场景
        //   适合：可以用来设计队列。队列特点先进先出，后进后出。   只是在首尾增删元素，用LinkedList来实现很合适
        //   适合：可以用来设计栈。栈特点后进先出，先进后出。

        // 创建队列
        LinkedList<String> queue = new LinkedList<>();  // 此时不要用多态 要不然没有首位方法
        queue.addLast("第1号人");
        queue.addLast("第2号人");
        queue.addLast("第3号人");
        queue.addLast("第4号人 ");
        System.out.println(queue);
        // 出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        System.out.println("------------------------------------");
        // 创建栈
        LinkedList<String> stack = new LinkedList<>();  // 此时不要用多态 要不然没有首位方法
        stack.addFirst("第1颗子弹"); // 跟push() 效果一样
        stack.addFirst("第2颗子弹");
        stack.addFirst("第3颗子弹");
        stack.addFirst("第4颗子弹");
        System.out.println(stack);
        // 出栈
        System.out.println(stack.removeFirst()); // 跟pop() 效果一样
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack);

    }
}





























