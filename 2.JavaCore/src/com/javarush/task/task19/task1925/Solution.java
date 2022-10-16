package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
В метод main первым параметром приходит путь к файлу1, вторым - путь к файлу2.
Файл1 содержит слова, разделенные пробелом или переводом строки (в файле может быть несколько строк).
Все, что не относится к пробелу или переводу строки, разделителем не считать.
Записать в одну строку через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура

1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length < 2) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            String line;
            String splitter = "";
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.length() > 6) {
                        writer.write(splitter + word);
                        splitter = ",";
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
