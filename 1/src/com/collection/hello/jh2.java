package com.collection.hello;

import com.collection.jh2.Student;
import com.collection.jh2.Student1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class jh2 {
    public static void main(String[] args) {
        System.out.println("1 set 集合");
        // Set<Integer> set = new HashSet<>(); // 创建了HashSet集合 一行经典代码 无序 不重复 无索引
        // Set<Integer> set = new LinkedHashSet<>(); // 创建了LinkedHashSet集合    有序 不重复 无索引
        Set<Integer> set = new TreeSet<>(); // 创建了TreeSet集合    排序（默认升序） 不重复 无索引
        set.add(555);
        set.add(666);
        set.add(666);
        set.add(888);
        set.add(777);
        System.out.println(set);

        // Set要用到的常用方法，基本上就是Collection提供的，自己几乎没有额外新增一些常用功能

        System.out.println();
        System.out.println("2 set 集合原理");
        // 哈希值：就是一个int类型的数值，java中每个对象都有一个哈希值，
        // java中所有对象，都可以调用Object类提供的hashcode()方法，返回对象自己的哈希值

        // 对象哈希值特点：同一个对象多次调用hashcode()方法，返回的哈希值是相同的
        // 不同对象的哈希值大多数情况下是不同的，但也有例外(哈希碰撞)，只是概率极小，几乎可以忽略不计
        Student s1 = new Student("张三", 18, 1.75 );
        Student s2 = new Student("李四", 19, 1.65 );
        System.out.println(s1.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        String str1 = new String("abc");
        String str2 = new String("acD");
        System.out.println(str1.hashCode()); // 哈希值一样
        System.out.println(str2.hashCode()); // 哈希值一样

        System.out.println();
        System.out.println("3 HashSet集合");
        // HashSet集合的底层原理：基于哈希表实现的。
        // 哈希表是一种增删改查数据，性能都较好的数据结构。所以HashSet集合也是。

        // 哈希表：jdk8之前，基于数组+链表实现的；jdk8开始之后，基于数组+链表+红黑树实现的

        // jdk8之前HashSet集合的底层原理：
        // 1 创建一个默认长度为16的数组，默认加载因子为0.75，数组名table
        // 2 使用元素的哈希值对数组的长度求余计算出应存入的位置
        // 3 判断当前位置是否为null，null则直接存入
        // 4 如果不为null，表示有元素，则调用equals方法比较，相等则不存；不相等则存入数组；
        //  （jdk8之前，新元素占老元素位置，老元素挂下面） （jdk8之后，新元素直接挂老元素下面）

        // 问题：如果链表过长，会导致查询性能降低，此时需要扩容，16*0.75=12，所以当元素个数达到12时，就会进行扩容
        // 扩容后如果元素过多 还是会出现链表过长；此时jdk8开始进行红黑树转换，将链表转换为红黑树，从而提高查询性能
        // jdk8开始 当链表长度超过8时，且数组长度>=64时，会转换链表为红黑树，红黑树是通过哈希值进行排序的

        // 了解数据结构 二叉树
        // 普通二叉树：， 开发中意义不大，了解即可

        // 二叉查找树（二叉排序树）：小的存左边，大的存右边，一样的不存。
        // 问题：一边独大，导致查询性能降低，此时需要平衡二叉查找树，如AVL树，红黑树等

        // 平衡二叉查找树：满足查找二叉树的大小规则下，让树尽可能的矮小，左右高度差不超过2，以此提高查数据的性能 开发中常用

        // 红黑数：就是可以自平衡的二叉树。是一种增删改查性能都相对较好的结构


        // HashSet集合的去重复机制：默认不能对内容一样的两个不同对象去重复,见下面：
        Set<Student> set2 = new HashSet<>();
        set2.add(new Student("张三", 18, 1.75 ));
        set2.add(new Student("张三", 18, 1.75 ));
        System.out.println(set2);

        // 如何解决HashSet集合的去重复机制不能对内容一样的两个不同对象去重复的问题？
        // 解决方法：重写Student类的equals()和hashCode()方法 见student类

        System.out.println();
        System.out.println("4 LinkedHashSet集合");
        // LinkedHashSet集合的底层原理：基于哈希表（数组+链表+红黑树）实现的
        // 但是，它的每个元素都额外的多了一个双链表的机制记录它前后元素的位置

        System.out.println();
        System.out.println("5 TreeSet集合");
        // TreeSet集合的底层原理：基于哈希表（数组+链表+红黑树）实现的
        // 但是，它额外的多了一个红黑树的机制，用于实现排序

        // 注意：
        // 对于数值类型：Integer、Double 默认安装数值本身的大小进行升序排序
        // 对于字符串类型：默认按照首字符的编号升序排序
        // 对于自定义类型对象如Student，TreeSet默认是无法直接排序的 如下代码会报错
//        Set<Student> set3 = new TreeSet<>();
//        set3.add(new Student("张三", 18, 1.75 ));
//        set3.add(new Student("李四", 19, 1.65 ));
//        System.out.println(set3);

        // 解决：
        // 方式1 Student类实现Comparable接口 重写Student类的compareTo()方法 见student1类
        Set<Student1> set4 = new TreeSet<>();
        set4.add(new Student1("张三", 18, 1.75 ));
        set4.add(new Student1("李四", 19, 1.65 ));
        set4.add(new Student1("王五", 19, 1.65 ));
        System.out.println(set4); // 王五没有了 因为TreeSet 此时是按照年龄排序的 王五的年龄和李四一样重复了

        // 方式2 通过调用TreeSet集合有参数构造器，可以设置Comparator对象（比较器对象，用于指定比较规则）
        Set<Student> set5 = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge());
        set5.add(new Student("张三", 18, 1.75 ));
        set5.add(new Student("李四", 19, 1.65 ));
        System.out.println(set5);

        // 如果方式1 和 方式2 同时存在，方式2优先

    }
}






















