package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/* 
Выделяем числа
1. Программа должна считывать пути к файлам с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором
   принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter
   с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(console.readLine()))) {
            String line;
            String result = "";
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                String space = "";
                for (String word : words) {
                    word = word.trim();
                    if (word.matches("[-+]?\\d+"))
                        try {
                            result += space + word;
                            space = " ";
                        } catch (Exception e) {
                        }
                }
            }
            writer.write(result);
        } catch (IOException e) {
        }
    }
}
