package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

------------Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013

1. +Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть
   сразу проинициализирована.
2. +Программа НЕ должна считывать данные с консоли.
3. +Программа должна считывать содержимое файла (используй FileReader).
4. +Поток чтения из файла (FileReader) должен быть закрыт.
5. +Программа должна заполнить список PEOPLE данными из файла.
6. +Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        if (args.length < 1) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals("")) {
                    String[] params = line.split(" ");
                    if (params.length >= 4) {
                        String name;
                        Date bdate;
                        if (true) {
                            LinkedList<String> list = new LinkedList<>(Arrays.asList(params));
                            Integer year = Integer.parseInt(list.pollLast());
                            Integer month = Integer.parseInt(list.pollLast());
                            Integer day = Integer.parseInt(list.pollLast());
                            name = String.join(" ", list);
                            bdate = new Date(year - 1900, month - 1, day);
                        } else {
                            name = "";
                            String space = "";
                            for (int i = 0; i < params.length - 3; i++) {
                                name = name + space + params[i];
                                if (space.equals("")) space = " ";
                            }
                            bdate = new Date(Integer.parseInt(params[params.length - 1]) - 1900,
                                    Integer.parseInt(params[params.length - 2]) - 1,
                                    Integer.parseInt(params[params.length - 3]));
                        }
                        PEOPLE.add(new Person(name, bdate));
                    }
                }
            }
            for (Person pers : PEOPLE)
                System.out.println(pers.getName() + " " + pers.getBirthDate());
        } catch (IOException e) {
        }
    }
}
