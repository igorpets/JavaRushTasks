package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new FileReader(scan.nextLine()))) {
            //...
            StringBuilder result = getLine(reader.readLine().split(" "));
            System.out.println(result.toString());
        } catch (Exception e) {
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder data = new StringBuilder();
        if (words != null) {
            ArrayList<String> list = new ArrayList<>();
            for (String word : words) {
                if (word != null && word.length() > 0) {
                    if (data.length() == 0)
                        data.append(word);
                    else
                        list.add(word);
                }
            }
            int last_size = 0;
            while (list.size() != 0 && last_size != list.size()) {
                last_size = list.size();
                for (int i = 0; i < list.size(); ) {
                    String word = list.get(i);
                    //System.out.println(word);
                    if (Character.toLowerCase(data.charAt(data.length() - 1)) == Character.toLowerCase(word.charAt(0))) {
                        data.append(" " + word);
                        list.remove(i);
                    } else if (Character.toLowerCase(data.charAt(0)) == Character.toLowerCase(word.charAt(word.length() - 1))) {
                        data.insert(0, word + " ");
                        list.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            for (String word : list) {
                data.append(" " + word);
            }
        }
        return data;
    }
}
