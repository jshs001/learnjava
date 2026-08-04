package com.itheima.rumen7;

public class Student1Operator {
    private Student1 student;

    public Student1Operator(Student1 student) {
        this.student = student;
    }

    public void printPass(){
        if(student.getScore() >= 60){
            System.out.println(student.getName() + "通过");
        }else{
            System.out.println(student.getName() + "未通过");
        }
    }
}
