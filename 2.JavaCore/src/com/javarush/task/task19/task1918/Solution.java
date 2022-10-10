package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

/* 
Знакомство с тегами
Считай с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>ewe ere

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми

1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length < 1) return;
        String tag = args[0];
        int tag_len = tag.length() + 2;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            String line;
            String str = "";
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                str += line.trim() + " ";
            }
            int index1;
            int index2;
            index1 = str.indexOf("<" + tag);
            index2 = str.indexOf("</" + tag + ">");
            if (index1 >= 0 && index2 > 0) {
                str = str.substring(index1);
                int count = 1;
                int curr = tag_len;
                while (count > 0 || index2 >= 0) {
                    index1 = str.indexOf("<" + tag, curr);
                    index2 = str.indexOf("</" + tag + ">", curr);
                    if (index1 < 0 && index2 > 0 && count == 1) {
                        // Последний закрывающий тег.
                        System.out.println(str.substring(0, index2 + tag_len + 1));
                        break;
                    } else if (index1 > 0 && index2 > 0 && index1 > index2 && count > 1) {
                        // Закрывающий тег.
                        System.out.println(str.substring(0, index2 + tag_len + 1));
                        str = str.substring(index1);
                        count--;
                    } else if (count > 0 && index1 > 0 && index2 > 0 && index1 < index2) {
                        // Вложенный тег.
                        curr = index1 + tag_len;
                        count++;
                    } else if (count > 1 && index1 > 0 && index2 > 0 && index1 > index2) {
                        // Закрываем вложенный тег.
                        curr = index1 + tag_len;
                        count++;
                    } else if (count == 0 && index1 > 0 && index2 > 0 && index1 < index2) {
                        // новый тег.
                        str = str.substring(index1);
                        count = 1;
                    } else {
                        break;
                    }
                }
            }
        } catch (IOException e) {
        }

    }
}
