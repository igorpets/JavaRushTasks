package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
В метод main первым параметром приходит путь к файлу.
Посчитать количество символов в файле, которые соответствуют буквам английского алфавита.
Вывести на экран число (количество символов).
Закрыть потоки.

1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать количество символов, которые соответствуют буквам английского алфавита, и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        String file_name = args[0];
        try (FileInputStream file = new FileInputStream(file_name)){
            byte[] buff = new byte[file.available()];
            file.read(buff);
            int count = 0;
            for (int i = 0; i<buff.length; i++)
                if ((buff[i]>='a' && buff[i]<='z')||(buff[i]>='A' && buff[i]<='Z')) count++;
            System.out.println(count);
        } catch (Exception e) {}
    }
}
