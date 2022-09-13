package com.javarush.task.task15.task1521;

/*
1. В классе Tree должен быть реализован метод info(Object s).
2. В классе Tree должен быть реализован метод info(Number s).
3. В классе Tree должен быть реализован метод info(String s).
4. Метод info(Number s) должен выводить на экран строку, аналогичную строке из метода info(Object s), заменив лишь фразу("метод Object" на "метод Number").
5. Метод info(String s) должен выводить на экран строку, аналогичную строке из метода info(Object s), заменив лишь фразу("метод Object" на "метод String").
*/
public class Tree {
    public static int globalNumber;
    public int number;

    public Tree() {
        this.number = ++globalNumber;
    }

    public void info(Object s) {
        System.out.println(String.format("Дерево № %d , метод Object, параметр %s", number, s.getClass().getSimpleName()));
    }
}
