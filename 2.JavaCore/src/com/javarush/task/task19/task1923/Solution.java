package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length < 2) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            String line;
            while ((line = reader.readLine())!= null){
                //System.out.println(line);
                String[] words = line.split(" ");
                for (String word: words){
                    if (word.matches("\\S*\\d\\S*")){
                        writer.write(word+" ");
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
