package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scan.nextLine())){
            int max = Integer.MIN_VALUE;
            while (input.available()>0)
                max = Math.max(max, input.read());
            System.out.println(max);
        }
    }
}
