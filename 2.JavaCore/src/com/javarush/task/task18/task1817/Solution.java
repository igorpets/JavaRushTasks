package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
В метод main первым параметром приходит путь к файлу.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой до ближайшего.
4. Закрыть потоки.


Requirements:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
4. Выведенное значение необходимо округлить до 2 знаков после запятой до ближайшего.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        String file_name = args[0];
        try (FileInputStream file = new FileInputStream(file_name)) {
            int count = file.available();
            byte[] buff = new byte[count];
            file.read(buff);
            int count_space = 0;
            for (int i = 0; i < count; i++)
                if (buff[i] == ' ') count_space++;
            float res = (count_space * 10000.0f / count);
            //System.out.println(res);
            res = Math.round(res)/100.0f;
            System.out.println(res);
        } catch (Exception e) {
        }
    }
}
