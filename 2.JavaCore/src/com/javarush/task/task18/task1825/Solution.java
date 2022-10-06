package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.

1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) {
        final String part = ".part";
        ArrayList<String> file_names = new ArrayList<>();
        try (Scanner scan = new Scanner(System.in)) {
            String line;
            while (!(line = scan.nextLine()).equals("end")) {
                int index = line.indexOf(part);
                if (index >= 0) {
                    int num = Integer.parseInt(line.substring(index + 5));
                    if (num > 0) {
                        while (num >= file_names.size())
                            file_names.add(null);
                        file_names.set(num - 1, line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (file_names.size() > 0) {
            String w_name = file_names.get(0);
            w_name = w_name.substring(0, w_name.indexOf(part));
            try (FileOutputStream out = new FileOutputStream(w_name)) {
                for (String fname : file_names) {
                    if (fname != null && !fname.equals("")) {
                        //System.out.println(fname);
                        try (FileInputStream input = new FileInputStream(fname)) {
                            byte[] buff = new byte[input.available()];
                            if (input.read(buff) == buff.length)
                                out.write(buff);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
