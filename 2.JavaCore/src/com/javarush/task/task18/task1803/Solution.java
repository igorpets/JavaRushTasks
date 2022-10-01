package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> data = new HashMap<>();
        try (Scanner scan = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scan.nextLine())) {
            while (input.available() > 0) {
                int num = input.read();
                if (data.containsKey(num))
                    data.replace(num, data.get(num) + 1);
                else
                    data.put(num, 1);
            }
            int max = Integer.MIN_VALUE;
            for (Integer val : data.values())
                if (max < val) max = val;
            //System.out.println("max=" + max + " size=" + data.size());
            for (Map.Entry<Integer, Integer> entry : data.entrySet())
                if (entry.getValue() == max)
                    System.out.print(entry.getKey()+" ");
            System.out.println();
        }
    }
}
