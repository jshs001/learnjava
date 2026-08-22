package com.itheima1.gaoji8;

import java.util.ArrayList;

public interface Data <T extends People>{
    void add(T t);
    ArrayList<T> getByName(String name);
}
