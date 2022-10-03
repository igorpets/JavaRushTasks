package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Scanner;

/* 
Объединение файлов
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) {
        String name1;
        String name2;
        try (Scanner scan = new Scanner(System.in)) {
            name1 = scan.nextLine();
            name2 = scan.nextLine();
        }
        if (name1 != null && name2 != null) {
            byte[] buff = null;

            try (FileInputStream file1 = new FileInputStream(name1);
                 FileInputStream file2 = new FileInputStream(name2)) {
                buff = new byte[file1.available() + file2.available()];
                int count = file2.read(buff);
                file1.read(buff, count, file1.available());
            } catch (Exception e) {
            }
            if (buff != null && buff.length > 0)
                try (FileOutputStream file3 = new FileOutputStream(name1)) {
                    file3.write(buff);
                } catch (Exception e) {
                }
        }
    }
}
