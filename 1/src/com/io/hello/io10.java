package com.io.hello;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class io10 {
    public static void main(String[] args) throws IOException {
        System.out.println("1 io框架");
        // 框架：解决某类问题，编写的一套类、接口等，可以理解成一个半成品，大多数框架都是第三方研发的。
        // 好处：在框架的基础上开发，可以得到优先的软件架构，并能提高开发效率
        // 框架的形式：一般把类、接口等编译成class形式，再压缩成一个.jar结尾的文件发行出去。

        // IO框架:
        // 封装了java提供的对文件、数据进行操作的代码，对外提供了更简单的方式来对文件进行操作，对数据进行读写等
        // Commons-io: Apache组织提供的一个常用的IO操作的jar包

        System.out.println();
        System.out.println("2 Commons-io");
        // 下载commons-io后解压 复制commons-io-2.22.0.jar到项目的lib目录（需要新建）下
        // 右键lib 选择添加到库

        // 复制文件
        FileUtils.copyFile(new File("1/src/com/io/io10/test.txt"), new File("1/src/com/io/io10/test1.txt"));

        // 复制文件夹
        FileUtils.copyDirectory(new File("1/src/com/io/io10/d1"), new File("1/src/com/io/io10/d2"));

        // 删除文件夹
        FileUtils.deleteDirectory(new File("1/src/com/io/io10/d2"));


        System.out.println();
        System.out.println("3 java io");
        // java提供的原生的一行代码搞定很多事情
        // Files.delete(Path.of("1/src/com/io/io10/test2.txt"));  // test2存在了 就不好办了  再此执行会报错
        Files.copy(Path.of("1/src/com/io/io10/test.txt"), Path.of("1/src/com/io/io10/test2.txt"));
        Files.delete(Path.of("1/src/com/io/io10/test2.txt"));
        System.out.println(Files.readString(Path.of("1/src/com/io/io10/test.txt")));


    }
}
