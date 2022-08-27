package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    //напишите тут ваш код
    public static void main(String[] args) {
        System.out.println(min(2, 5));
        System.out.println(min(7, 2, 5));
        System.out.println(min(7, 10, 2, 5));
        System.out.println(min(7, 2, 5, 15, 25));
        System.out.println(max(25, 2, 5, 15, 25));
        System.out.println(max(25, 2, 5, 15));
        System.out.println(max(25, 2, 5));
        System.out.println(max(25, 5));
    }

    public static int min(int a1, int a2) {
        return Math.min(a1, a2);
    }

    public static int min(int a1, int a2, int a3) {
        return min(min(a1, a2), a3);
    }

    public static int min(int a1, int a2, int a3, int a4) {
        return min(min(a1, a2, a3), a4);
    }

    public static int min(int a1, int a2, int a3, int a4, int a5) {
        return min(min(a1, a2, a3, a4), a5);
    }

    public static int max(int a1, int a2) {
        return Math.max(a1, a2);
    }

    public static int max(int a1, int a2, int a3) {
        return max(max(a1, a2), a3);
    }

    public static int max(int a1, int a2, int a3, int a4) {
        return max(max(a1, a2, a3), a4);
    }

    public static int max(int a1, int a2, int a3, int a4, int a5) {
        return max(max(a1, a2, a3, a4), a5);
    }
}
