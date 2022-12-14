package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу
   проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строки: "first","second","third","fourth","fifth".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream
   c конструктором принимающим ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль
   объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строки(вставлять контекстную рекламу) выведенные
   методом printSomething() согласно заданию, и выводить её в консоль.
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original_out = System.out;
        ByteArrayOutputStream my_out = new ByteArrayOutputStream();
        PrintStream my_print = new PrintStream(my_out);
        System.setOut(my_print);
        testString.printSomething();
        //**********
        String[] lines = my_out.toString().split("\\r?\\n");
        int count = 0;
        for (String line:lines){
            count++;
            original_out.println(line);
            if (count>=2){
                original_out.println("JavaRush - курсы Java онлайн");
                count = 0;
            }
        }
        //**********
        System.setOut(original_out);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
