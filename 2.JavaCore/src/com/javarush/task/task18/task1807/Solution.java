package com.javarush.task.task18.task1807;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Подсчет запятых
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scan.nextLine())) {
            int code = ',';
            int count = 0;
            while (input.available() > 0) {
                if (code == input.read())
                    count++;
            }
            System.out.println(count);
        } catch (Exception e) {

        }
    }
}
