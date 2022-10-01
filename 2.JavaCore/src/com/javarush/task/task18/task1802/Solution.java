package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scan.nextLine())){
            int min = Integer.MAX_VALUE;
            while (input.available()>0)
                min = Math.min(min, input.read());
            System.out.println(min);
        }
    }
}
