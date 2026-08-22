package com.itheima1.gaoji5;

import java.util.ArrayList;

public class StudentOperatorImpl1 implements StudentOperator {
    @Override
    public void printInfo(ArrayList<Student> students) {
        System.out.println("-----------------全班全部学生信息如下------------------");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println("姓名"+s.getName()+"\t性别"+s.getSex()+"\t分数"+s.getScore());
        }
        System.out.println("---------------------------------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        double sum = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            sum += s.getScore();
        }
        System.out.println("全班平均分是："+sum/students.size());
    }
}
