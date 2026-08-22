package com.itheima1.gaoji5;

import java.util.ArrayList;

public class StudentOperatorImpl2 implements StudentOperator {
    @Override
    public void printInfo(ArrayList<Student> students) {
        System.out.println("-----------------全班全部学生信息如下------------------");
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println("姓名"+s.getName()+"\t性别"+s.getSex()+"\t分数"+s.getScore());
            if (s.getSex() == '男') {
                count1++;
            } else {
                count2++;
            }
        }
        System.out.println("男生人数是："+count1+"\t女生人数是："+count2);
        System.out.println("班级总人数是："+students.size());
        System.out.println("---------------------------------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        double sum = 0;
        double max = students.get(0).getScore();
        double min = students.get(0).getScore();
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            sum += s.getScore();
            if (s.getScore() > max) {
                max = s.getScore();
            }
            if (s.getScore() < min) {
                min = s.getScore();
            }
        }
        System.out.println("最高分是："+max);
        System.out.println("最低分是："+min);
        System.out.println("全班平均分是："+(sum - max - min)/(students.size()-2));
    }
}
