package com.javarush.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Статики-2
3. Программа должна считывать данные с клавиатуры в статическом блоке.
4. Программа должна инициализировать поля A и B в статическом блоке согласно введенным с клавиатуры значениям.
5. Программа должна выводить в консоль минимальное из введенных с клавиатуры значений.
*/

public class Solution {
    public static int A;
    public static int B;

    static {
        try (Scanner scan = new Scanner(System.in)) {
            while (!scan.hasNextInt()) scan.next();
            A = scan.nextInt();
            while (!scan.hasNextInt()) scan.next();
            B = scan.nextInt();
        } catch (Exception e) {

        }
    }
    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
