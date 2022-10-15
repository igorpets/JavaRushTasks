package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/* 
Два в одном
+1. Программа должна три раза считать имена файлов с консоли.
+2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
+3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in);
             FileOutputStream writer1 = new FileOutputStream(scan.nextLine());
             FileInputStream reader1 = new FileInputStream(scan.nextLine());
             FileInputStream reader2 = new FileInputStream(scan.nextLine())) {
            byte[] buff = new byte[reader1.available()];
            int count = reader1.read(buff);
            writer1.write(buff, 0, count);
        } catch (Exception e) {
        }
    }
}
