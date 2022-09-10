package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in)) {
            while (!scan.hasNextLong()) continue;
            long num1 = scan.nextLong();
            while (!scan.hasNextLong()) continue;
            long num2 = scan.nextLong();
            System.out.println(gcdByEuclidsAlgorithm(num1, num2));
        } catch (Exception e) {

        }
    }

    static long gcdByEuclidsAlgorithm(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
