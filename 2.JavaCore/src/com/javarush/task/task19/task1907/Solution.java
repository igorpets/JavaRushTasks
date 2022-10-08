package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.

1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.

Ex: world/.we,world,!retr,;eerrrr,world,&deervf,!world1,
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            String line;
            int count = 0;
            if (true) {
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\W");
                    for (String word : words)
                        if (word.trim().equals("world")) count++;
                }
            } else {
                count = reader.lines()
                        .map(s -> s.split("world"))
                        .mapToInt(x -> x.length)
                        .sum() - 1;
            }
            System.out.println(count);
        } catch (IOException e) {

        }
    }
}
