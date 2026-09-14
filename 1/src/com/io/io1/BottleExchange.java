package com.io.io1;

public class BottleExchange {

    // 定义一个结果类来存放多个返回值
    public static class Result {
        int totalDrunk;   // 总共喝的瓶数
        int remCaps;      // 剩余盖子数
        int remBottles;   // 剩余空瓶数

        public Result(int totalDrunk, int remCaps, int remBottles) {
            this.totalDrunk = totalDrunk;
            this.remCaps = remCaps;
            this.remBottles = remBottles;
        }
    }

    public static void Suan() {
        int money = 10;
        Result result = maxBottles(money);

        System.out.println("--- 计算结果 ---");
        System.out.println("10元总共可以喝: " + result.totalDrunk + " 瓶");
        System.out.println("最终剩余瓶盖: " + result.remCaps + " 个");
        System.out.println("最终剩余空瓶: " + result.remBottles + " 个");
    }

    public static void Suan(int money) {
        Result result = maxBottles(money);

        System.out.println("--- 计算结果 ---");
        System.out.println("10元总共可以喝: " + result.totalDrunk + " 瓶");
        System.out.println("最终剩余瓶盖: " + result.remCaps + " 个");
        System.out.println("最终剩余空瓶: " + result.remBottles + " 个");
    }

    public static Result maxBottles(int money) {
        int price = 2;
        // 初始用钱买到的饮料数量
        int bottles = money / price;

        int totalDrunk = bottles; // 喝掉的总瓶数
        int caps = bottles;        // 当前拥有的瓶盖数
        int emptyBottles = bottles;// 当前拥有的空瓶数

        // 只要瓶盖大于等于4个，或者空瓶大于等于2个，就可以继续兑换
        while (caps >= 4 || emptyBottles >= 2) {
            int newFromCaps = caps / 4;
            int newFromBottles = emptyBottles / 2;
            int newTotal = newFromCaps + newFromBottles;

            // 累加喝掉的数量
            totalDrunk += newTotal;

            // 更新剩余的瓶盖：之前没兑换完的 + 喝完新饮料产生的
            caps = (caps % 4) + newTotal;

            // 更新剩余的空瓶：之前没兑换完的 + 喝完新饮料产生的
            emptyBottles = (emptyBottles % 2) + newTotal;
        }

        // 返回包含所有数据的结果对象
        return new Result(totalDrunk, caps, emptyBottles);
    }
}
