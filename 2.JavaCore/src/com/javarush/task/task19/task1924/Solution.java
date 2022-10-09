package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
1. +Класс Solution должен содержать публичное статическое поле map типа Map<Integer, String>, которое должно быть
   сразу проинициализировано.
2. +Программа должна считывать имя файла с консоли (используй BufferedReader).
3. +BufferedReader для считывания данных с консоли должен быть закрыт.
4. +Программа должна считывать содержимое файла (используй FileReader).
5. +Поток чтения из файла (FileReader) должен быть закрыт.
6. Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
7. Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            String line;
            while((line = reader.readLine())!=null) {
                for(Map.Entry<Integer, String> entry:map.entrySet())
                    line = line.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                System.out.println(line);
            }
        } catch (IOException e) {}
    }
}
