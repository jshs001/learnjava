package com.itheima.hello;

public class debug {
    public static void main(String[] args) {
        // idea自带断点调试工具，可以控制代码从断点开始一行一行的执行，然后详细观察执行的过程

        // 求数组元素的最大值 案例
        int[] a = {1,2,3,4,5};
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("最大值是：" + max);

        // debug 操作点行号后 行号多个红点就是断点 ，然后右键debug启动或调试启动
        //   启动后程序会运行到断点位置 然后暂停 ，然后出现debug调试器界面
        //   点下一步(下载按钮)，点一下就执行一步，debug界面同时会显示当前执行的行号和变量的值，代码界面会高量亮当前行 同时显示当前变量的值

        // debug调试的最终结果是在调试界面的控制台页显示的
        // 当点几下下一步 看完问题后 直接按f9 结束调试运行完程序 就会在控制台显示最终结果
    }
}
