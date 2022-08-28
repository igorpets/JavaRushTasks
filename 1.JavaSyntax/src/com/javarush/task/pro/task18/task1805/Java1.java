package com.javarush.task.pro.task18.task1805;

// 1 4 2 3 5
public class Java1 {
    static {
        System.out.println(1);
    }
    {
        System.out.println(2);
    }
    public Java1(){
        System.out.println(3);
    }
    public static void main(String[] args) {
        System.out.println(4);
        new Java1();
        System.out.println(5);
    }
}
