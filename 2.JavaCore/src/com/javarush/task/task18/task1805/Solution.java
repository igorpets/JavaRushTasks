package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        TreeSet<Integer> data = new TreeSet<>();
        try (Scanner scan = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scan.nextLine())) {
            while (input.available() > 0) {
                data.add(input.read());
            }
            for (Integer val : data)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
