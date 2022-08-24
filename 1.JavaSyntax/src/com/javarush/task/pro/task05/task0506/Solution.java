package com.javarush.task.pro.task05.task0506;

import java.util.Scanner;

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        array = new int[n];

        for (int i = 0; i < array.length;) {
            if (s.hasNextInt()) {
                array[i++] = s.nextInt();
            } else s.next();
        }

        int min = array[0];

        for (int k = 1; k < array.length; k++) {
            int a = array[k];
            if (a < min) {
                min = a;
            }
        }
        System.out.println(min);
    }

}
