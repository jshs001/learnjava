package com.itheima.rumen9;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodOperator {
    private ArrayList<Food> foodList = new ArrayList<>();

    public void addFood() {

        Food f = new Food();

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入菜名：");
        String name = sc.next();
        f.setName(name);

        System.out.println("请输入价格：");
        double price = sc.nextDouble();
        f.setPrice(price);

        System.out.println("请输入描述：");
        String desc = sc.next();
        f.setDesc(desc);

        foodList.add(f);
        System.out.println("菜品上架成功！");
    }

    public void showFood() {
        if (foodList.size() == 0) {
            System.out.println("没有菜品！");
        } else {
            System.out.println("菜名\t价格\t描述");
            for (int i = 0; i < foodList.size(); i++) {
                Food f = foodList.get(i);
                System.out.println(f.getName() + "\t" + f.getPrice() + "\t" + f.getDesc());
            }
        }
    }

    public void start() {
        while (true) {
            System.out.println("请选择功能");
            System.out.println("1. 上架菜品");
            System.out.println("2. 浏览菜品");
            System.out.println("3. 退出系统");

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入功能编号：");
            String num = sc.next();
            switch (num) {
                case "1":
                    addFood();
                    break;
                case "2":
                    showFood();
                    break;
                case "3":
                    System.out.println("谢谢使用！");
                    return;
                default:
                    System.out.println("输入有误！");
            }
        }
    }
}
