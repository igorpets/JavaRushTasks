package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с
одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957
Алексеев Дмитрий Семенович 24 08 1978

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен
читать данные только одного человека.

1. +PersonScanner должен быть интерфейсом.
2. +Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. +Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. +Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. +Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные
   только одного человека, в виде объекта класса Person.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(Paths.get("input.txt"))) {
            PersonScanner personScannerAdapter = new PersonScannerAdapter(scanner);
            System.out.println(personScannerAdapter.read());
            System.out.println(personScannerAdapter.read());
            System.out.println(personScannerAdapter.read());
            System.out.println(personScannerAdapter.read());
            personScannerAdapter.close();
        } catch (Exception e) {
        }
        // Date birthDate = new Date(year - 1900, month - 1, date);
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner scan) {
            fileScanner = scan;
        }

        @Override
        public Person read() throws IOException {
            Person result = null;
            if (fileScanner != null)
                try {
                    String line = fileScanner.nextLine();
                    if (line != null && !line.equals("")){
                        String[] params = line.split(" ");
                        if (params != null && params.length>=6)
                            result = new Person(params[1], params[2], params[0],
                                    new Date(Integer.parseInt(params[5]) - 1900,
                                            Integer.parseInt(params[4]) - 1,
                                            Integer.parseInt(params[3])));
                    }
                } catch (Exception e) {
                }
            return result;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
