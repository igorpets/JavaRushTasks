package com.javarush.task.task19.task1916;

import java.io.*;
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
8. +Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций
   ADDED, REMOVED, SAME.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        boolean test = false;
        if (test) {
            //кладем данные в строку
            StringBuilder sb = new StringBuilder();
            sb.append("input.txt").append('\n');
            sb.append("input2.txt").append('\n');
            String data = sb.toString();
            //Оборачиваем строку в класс ByteArrayInputStream
            InputStream is = new ByteArrayInputStream(data.getBytes());
            //подменяем in
            System.setIn(is);
        }

        // Основной блок по чтению файлов и записи результата.
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
            int index1 = 0, index2 = 0;
            while (index1 < list1.size() || index2 < list2.size()) {
                String line10 = null;
                String line11 = null;
                String line20 = null;
                String line21 = null;

                if (index1 < list1.size())
                    line10 = list1.get(index1);
                if (index1 + 1 < list1.size())
                    line11 = list1.get(index1 + 1);

                if (index2 < list2.size())
                    line20 = list2.get(index2);
                if (index2 + 1 < list2.size())
                    line21 = list2.get(index2 + 1);
                if (test)
                    System.out.println("1: " + line10 + " " + line11 + " 2: " + line20 + " " + line21);

                if (line10 != null && line20 != null && line10.equals(line20)) {
                    // Одинаковые строки.
                    lines.add(new LineItem(Type.SAME, line10));
                    index1++;
                    index2++;
                } else if (line20 != null && (line10 == null || line10.equals(line21))) {
                    // Добавлена новая строка line20
                    lines.add(new LineItem(Type.ADDED, line20));
                    index2++;
                } else if (line10 != null && (line20 == null || line20.equals(line11))) {
                    // Удалена строка line10
                    lines.add(new LineItem(Type.REMOVED, line10));
                    index1++;
                } else {
                    // По условиям задачи, такой ситуации не должно быть, печатаем ошибку.
                    if (test) {
                        System.out.println("ERROR SAME after ADDED/REMOVED index1=" + index1 + " index2=" + index2);
                        break;
                    }
                    index1++;
                    index2++;
                }
            }
            if (test)
                for (LineItem item : lines) {
                    String type = "UNKNOWN";
                    if (item.type == Type.REMOVED) type = "REMOVED";
                    else if (item.type == Type.ADDED) type = "ADDED";
                    else if (item.type == Type.SAME) type = "SAME";
                    System.out.println(type + " " + item.line);
                }
        } catch (IOException e) {
        }
    }


    // Константы - признаки операции со строкой.
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
