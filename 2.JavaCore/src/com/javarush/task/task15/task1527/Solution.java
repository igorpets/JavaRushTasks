package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Парсер реквестов
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        int index = url.indexOf('?');
        String result = "";
        String obj = null;
        if (index >= 0) {
            String[] vars = url.substring(index + 1).split("&");
            for (String str : vars) {
                String[] pair = str.split("=");
                if (!pair[0].equals("")) {
                    result = result + pair[0] + " ";
                    if (pair[0].equals("obj") && pair.length > 1 && (!pair[1].equals(""))) {
                        obj = pair[1];
                    }
                }
            }
        }
        System.out.println(result);
        if (obj != null) {
            try {
                double val = Double.parseDouble(obj);
                alert(val);
            } catch (Exception e) {
                alert(obj);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
