package com.itheima1.gaoji8;

// 泛型类
public class MyArrayList<E> {  // 这里的<E>可以换为<A>等等
    private Object[] arr = new Object[10];
    private int size; // 记录当前位置

    public boolean add(E e){
        arr[size] = e;
        size++;
        return true;
    }

    public E get(int index){
        return (E) arr[index];
    }
}
