package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
1. Программа должна использовать классы FileInputStream и FileOutputStream.
2. Программа должна переписать все байты одного файла в другой одним куском.
3. Потоки FileInputStream и FileOutputStream должны быть закрыты.
4. Нужно исправить 4 ошибки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream("c:/data.txt");
             // Создаем поток-записи-байт-в-файл
             FileOutputStream outputStream = new FileOutputStream("c:/result.txt")) {
            if (inputStream.available() > 0) {
                //читаем весь файл одним куском
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                if (count > 0) {
                    outputStream.write(buffer);
                }
            }
        } catch (Exception e) {

        }
    }
}
