package com.changyongapi.hello;

import java.util.Arrays;

public class cy8 {
    public static void main(String[] args) {
        System.out.println("1 算法");
        // 1 概念：解决某个实际问题的过程和方法。

        System.out.println("2 排序算法");
        System.out.println("2.1 冒泡排序");
        // 每次都从数组中找出最大的元素，放到数组的末尾

        int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
        System.out.println(Arrays.toString(array));

        System.out.println("2.2 选择排序");
        // 每轮选择当前位置，开始找出后面的较小值与该位置交换
        int[] array1 = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        for (int i = 0; i < array1.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array1.length; j++) {
                if (array1[j] < array1[minIndex]) {
                    minIndex = j;
                }
            }
            // 决定是否交换 优化
            if (minIndex != i){
                int temp = array1[i];
                array1[i] = array1[minIndex];
                array1[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(array1));

        System.out.println("3 查找算法");
        System.out.println("3.1 二分查找");
        // 前提条件：数组中的数据必须是有序的
        // 每次排除一半的数据，查询数据的性能明显提高很多

        int[] array2 = {7,23,79,81,103,127,131,147};
        int target = 103;
        binarySearch(array2, target); // 输出结果为：4


    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                System.out.println(mid);
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}






















