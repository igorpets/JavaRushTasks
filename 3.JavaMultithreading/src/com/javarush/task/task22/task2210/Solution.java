package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/* 
StringTokenizer
1. Метод getTokens должен использовать StringTokenizer.
2. Метод getTokens должен быть публичным.
3. Метод getTokens должен принимать два параметра типа String.
4. Массив типа String возвращенный методом getTokens должен быть заполнен правильно(согласно условию задачи).
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tok = new StringTokenizer(query, delimiter);
        String[] result = new String[tok.countTokens()];
        int i = 0;
        while(tok.hasMoreTokens()) {
            result[i++] =  tok.nextToken();
        }
        return result;
    }
}
