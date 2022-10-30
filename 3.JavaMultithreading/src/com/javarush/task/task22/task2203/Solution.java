package com.javarush.task.task22.task2203;

/* 
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.

+1. Класс TooShortStringException должен быть потомком класса Exception.
+2. Метод getPartOfString должен принимать строку в качестве параметра.
+3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
+4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();
        int index1 = string.indexOf('\t');
        int index2 = string.indexOf('\t', index1+1);
        if (index1>=0 && index2>index1)
            return string.substring(index1+1,index2);
        else
            throw new TooShortStringException();
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
