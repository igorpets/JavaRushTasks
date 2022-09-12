package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

import javax.management.RuntimeErrorException;

public class Solution {
    public static int A = 0;

    static {
        //throw an exception here - выбросьте эксепшн тут
        int[] aa= new int[5];
        if (2==2) System.out.println(aa[10]);
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
