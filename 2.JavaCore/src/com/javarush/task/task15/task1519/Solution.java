package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Разные методы для разных типов
3. Если введенная строка содержит точку("."), и ее можно корректно преобразовать в число типа Double - должен быть вызван метод print(Double value).
4. Если введенная строка может быть корректно преобразована в число типа short и полученное число больше 0, но меньше 128 - должен быть вызван метод print(short value).
5. Если введенная строка может быть корректно преобразована в число типа Integer и полученное число меньше или равно 0 или больше или равно 128 - должен быть вызван метод print(Integer value).
6. Во всех остальных случаях должен быть вызван метод print(String value).
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                String line = scan.nextLine();
                if (line.equals("exit")) break;
                if (line.indexOf('.') >= 0) try {
                    Double doub = Double.parseDouble(line);
                    print(doub);
                    continue;
                } catch (Exception e) {

                }
                Integer num;
                try {
                    num = Integer.parseInt(line);
                    if (num > 0 && num < 128)
                        print(num.shortValue());
                    else
                        print(num);
                    continue;
                } catch (Exception e) {

                }
                print(line);
            }
        } catch (Exception e) {

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
