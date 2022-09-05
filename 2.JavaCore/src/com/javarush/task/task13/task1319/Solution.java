package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа не должна ничего считывать из файловой системы.
4. Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
5. Программа должна записать все введенные строки (включая "exit", но не включая имя файла) в файл: каждую строчку — с новой строки.
6. Метод main должен закрывать объект типа BufferedWriter после использования.
7. Метод main не должен выводить данные на экран.
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             FileOutputStream output = new FileOutputStream(scanner.nextLine());
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output))) {
            String line = "";
            while (! line.equals("exit")) {
                line = scanner.nextLine();
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {

        }
    }
}
