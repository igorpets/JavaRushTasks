package com.javarush.task.task14.task1409;

/* 
Мосты

5. В классе Solution должен быть реализован публичный(public) метод println c одним параметром типа Bridge.
6. Метод println должен выводить в консоли количество машин (результат работы метода getCarsCount) для переданного ему моста (объекта типа Bridge).
7. В интерфейсе Bridge должен быть определен метод int getCarsCount().
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }

    //add println method here
    public static void println(Bridge bridge) {
        System.out.println(bridge.getCarsCount());
    }
}

