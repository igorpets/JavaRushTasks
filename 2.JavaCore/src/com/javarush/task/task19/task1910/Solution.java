package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/* 
Пунктуация
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая
   символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(console.readLine()))) {
            String line;
            /*
            while ((line = reader.readLine()) != null) {
                writer.write(line.chars()
                        .filter(Character::isLetterOrDigit)
                        .mapToObj(i -> String.valueOf((char) i))
                        .collect(Collectors.joining()));
            }
            */
            while (reader.ready()) {
                int c = reader.read();
                if (c >= 48 && c <= 57 || c >= 65 && c <= 90 || c >= 97 && c <= 122 || c == 32) {
                    writer.write(c);
                }
            }
        } catch (IOException e) {
        }
    }
}
