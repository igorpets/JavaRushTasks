package com.javarush.task.pro.task11.task1104;

/* 
Конвертер строки
*/

public class Solution {
    public static void main(String[] args) {
        String string = "12.84";
        //напишите тут ваш код
        double res = Double.parseDouble(string);
        long res2 = Math.round(res);
        System.out.println(res2);
    }
}
