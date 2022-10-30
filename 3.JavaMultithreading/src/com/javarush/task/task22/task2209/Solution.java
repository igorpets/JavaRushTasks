package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        //...
        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        return null;
    }
}
