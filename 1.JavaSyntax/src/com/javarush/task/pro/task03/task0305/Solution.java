package com.javarush.task.pro.task03.task0305;

import java.util.Scanner;

/*
Три числа
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner x = new Scanner(System.in);
        int q = x.nextInt();
        int w = x.nextInt();
        int r = x.nextInt();
        if (q == w) {
            if (w == r)
                System.out.println(q +" "+w+" "+r);
            else
                System.out.println(q +" "+w);
        }
        if (q == r) {
            if (w == r)
                ;
            else
                System.out.println(q +" "+r);
        }
        if (w == r) {
            if (w == q)
                ;
            else
                System.out.println(r +" "+w);
        }
    }
}