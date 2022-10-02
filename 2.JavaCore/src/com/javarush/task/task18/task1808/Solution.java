package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Scanner;

/* 
Разделение файла
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scan.nextLine());
             FileOutputStream out1 = new FileOutputStream(scan.nextLine());
             FileOutputStream out2 = new FileOutputStream(scan.nextLine())) {
            int count = input.available();
            int count1 = (count + 1) / 2;
            int count2 = count - count1;
            byte[] buffer = new byte[Math.max(count1, count2)];
            int read = input.read(buffer, 0, count1);
            if (read > 0) {
                out1.write(buffer, 0, read);
            }
            read = input.read(buffer, 0, count2);
            if (read > 0) {
                out2.write(buffer, 0, read);
            }
        } catch (Exception e) {

        }
    }
}
