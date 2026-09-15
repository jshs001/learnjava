package com.io.io4;

public class MyConnection implements AutoCloseable{
    @Override
    public void close() {
        System.out.println("释放了与某个硬件的链接资源~~~~~~~");
    }
}
