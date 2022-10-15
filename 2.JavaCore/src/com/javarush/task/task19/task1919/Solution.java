package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы
   в возрастающем порядке по имени.
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length < 1) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            TreeMap<String, Double> data = new TreeMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals("")) {
                    String[] params = line.split(" ");
                    if (params.length >= 2) {
                        double val = Double.parseDouble(params[1]);
                        String name = params[0];
                        if (data.containsKey(name))
                            data.replace(name, data.get(name) + val);
                        else
                            data.put(name, val);
                    }
                }
            }
            for (Map.Entry<String, Double> entry: data.entrySet()){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
