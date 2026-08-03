package com.itheima.rumen7;

public class Student {
    public String name;
    public double chinese;
    public double math;
    public double score;

    public void pringTotalScore(){
        double total = chinese + math;
        System.out.println(name + "的总分是：" + total);
    }
    public void printAvgScore(){
        double avg = (chinese + math) / 2;
        System.out.println(name + "的平均分是：" + avg);
    }

    public void printThis(){
        System.out.println(this);
    }

    public void printPass(double  score){
        if(this.score > score){
            System.out.println(name + "通过");
        }
    }
}
