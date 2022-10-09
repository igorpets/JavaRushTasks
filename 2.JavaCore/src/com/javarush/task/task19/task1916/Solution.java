package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
1. +Класс Solution должен содержать класс LineItem.
2. +Класс Solution должен содержать enum Type.
3. +Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу
   проинициализировано.
4. +В методе main(String[] args) программа должна считывать пути к файлам с консоли (используй BufferedReader).
5. +В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. +Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. +Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций
   ADDED, REMOVED, SAME.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file1 = new BufferedReader(new FileReader(console.readLine()));
             BufferedReader file2 = new BufferedReader(new FileReader(console.readLine()))) {
            ArrayList<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();
            String line;
            while ((line = file1.readLine()) != null)
                if (!line.equals(""))
                    list1.add(line);
            while ((line = file2.readLine()) != null)
                if (!line.equals(""))
                    list2.add(line);
            int index1, index2;

            //while (index)
        } catch (IOException e) {
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
