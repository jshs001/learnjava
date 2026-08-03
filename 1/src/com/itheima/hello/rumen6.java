package com.itheima.hello;

import java.util.Random;
import java.util.Scanner;

public class rumen6 {
    public static void main(String[] args) {
        // 双色球是 6个红球0-33的数字，1个是蓝球1-16中选择
        // 完成双色球系统的开发

        // 1 存储用户投注的7个号码
        int[] userNumbers = userSelectNumbers();
        printArray(userNumbers);

        // 2 创建一个方法，用于生成随机的7位中将号码
        int[] luckNumbers = createLuckNumbers();
        printArray(luckNumbers);

        // 3 创建一个方法，用于判断用户是否中奖
        checkWin(userNumbers, luckNumbers);

    }

    // 创建一个方法，用于打印数组
    public static void printArray(int[] numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + ", ");
            }
        }
        System.out.println("]");
    }


    // 1 创建一个方法，用于存储用户投注的7个号码
    public static int[] userSelectNumbers() {
        int[] numbers = new int[7];

        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < numbers.length - 1; i++) {
            while (true) {
                System.out.println("请您输入第" + (i + 1) + "个红球号码（1-33之间，不能重复）：");
                int number = sc.nextInt();

                if (number < 1 || number > 33) {
                    System.out.println("您输入的红球号码不在1-33之间，请重新输入：");
                } else {
                    if (exist(numbers, number)) {
                        System.out.println("您输入的号码已经存在，请重新输入：");
                    } else {
                        numbers[i] = number;
                        break;
                    }
                }
            }
        }
        while (true) {
            System.out.println("请您输入第7个蓝球号码（1-16之间，不能重复）：");
            int number = sc.nextInt();
            if (number < 1 || number > 16) {
                System.out.println("您输入的号码不在1-16之间，请重新输入：");
            } else {
                numbers[numbers.length - 1] = number;
                break;
            }
        }
        return numbers;
    }

    private static boolean exist(int[] numbers, int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                break;
            }
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }

    // 2 设计一个方法 随机一组中将号码处理（6个红球 1个篮球）
    public static int[] createLuckNumbers() {
        int[] numbers = new int[7];
        Random r = new Random();
        for (int i = 0; i < numbers.length - 1; i++) {
            while (true) {
                int number = r.nextInt(33) + 1;
                if (!exist(numbers, number)) {
                    numbers[i] = number;
                    break;
                }
            }
        }
        numbers[numbers.length - 1] = r.nextInt(16) + 1;
        return numbers;
    }

    // 3 创建一个方法，用于判断用户是否中奖
    public static void checkWin(int[] userNumbers, int[] luckNumbers) {
        int redCount = 0;
        int blueCount = 0;
        for (int i = 0; i < userNumbers.length - 1; i++) {
            for (int j = 0; j < luckNumbers.length - 1; j++) {
                if (userNumbers[i] == luckNumbers[j]) {
                    redCount++;
                    break;
                }
            }
        }

        blueCount = userNumbers[userNumbers.length - 1] == luckNumbers[luckNumbers.length - 1] ? 1 : 0;

        System.out.println("红球命中个数是：" + redCount + "个");
        System.out.println("蓝球命中个数是：" + blueCount + "个");

        switch (redCount) {
            case 6:
                if (blueCount == 1) {
                    System.out.println("恭喜你，中奖了1000万元");
                } else {
                    System.out.println("恭喜你，中奖了500万元");
                }
                break;
            case 5:
                if (blueCount == 1) {
                    System.out.println("恭喜你，中奖了10万元");
                } else {
                    System.out.println("恭喜你，中奖了5万元");
                }
                break;
            case 4:
                if (blueCount == 1) {
                    System.out.println("恭喜你，中奖了2万元");
                } else {
                    System.out.println("恭喜你，中奖了1万元");
                }
                break;
            case 3:
                if (blueCount == 1) {
                    System.out.println("恭喜你，中奖了0.8万元");
                } else {
                    System.out.println("恭喜你，中奖了0.5万元");
                }
                break;
            case 2:
                if (blueCount == 1) {
                    System.out.println("恭喜你，中奖了0.2万元");
                } else {
                    System.out.println("恭喜你，中奖了0.1万元");
                }
                break;
            case 1:
                if (blueCount == 1) {
                    System.out.println("恭喜你，中奖了0.08万元");
                } else {
                    System.out.println("恭喜你，中奖了0.05万元");
                }
                break;
            case 0:
                if (blueCount == 1) {
                    System.out.println("恭喜你，中奖了0.02万元");
                } else {
                    System.out.println("恭喜你，中奖了0.01万元");
                }
                break;
            default:
                System.out.println("恭喜你，未中奖");
                break;
        }

    }

}


























