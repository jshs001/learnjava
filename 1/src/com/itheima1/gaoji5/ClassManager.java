package com.itheima1.gaoji5;

import java.util.ArrayList;

public class ClassManager {
    private ArrayList<Student> students = new ArrayList<>();
//    private StudentOperator studentOperator = new StudentOperatorImpl1(); // 这里随时可以切换StudentOperator的实现类为StudentOperatorImpl2
    private StudentOperator studentOperator = new StudentOperatorImpl2(); // 这里随时可以切换StudentOperator的实现类为StudentOperatorImpl2

    public ClassManager (){
        students.add(new Student("张三", '男', 80));
        students.add(new Student("李四", '女', 90));
        students.add(new Student("王五", '男', 75));
        students.add(new Student("赵六", '女', 85));
        students.add(new Student("孙七", '男', 95));
        students.add(new Student("周八", '女', 60));
    }

    // 打印全班全部学生信息
    public void printInfo(){
        studentOperator.printInfo(students);
    }


    // 打印全班全部学生平均分
    public void printAverageScore(){
        studentOperator.printAverageScore(students);
    }
}
