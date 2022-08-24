package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
Получение информации по API
------------------------------    отдать на проверку!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        //напишите тут ваш код
        URLConnection connection = null;
        try {
            connection = url.openConnection();
            connection.setDoOutput(true);
        } catch (Exception e) {
        }
        if (connection != null) {
            try (OutputStream output = connection.getOutputStream();
                PrintStream printStream = new PrintStream(output)) {
                printStream.print("Hello!");
            }
            try (InputStream input = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
                while (reader.ready()) {
                    System.out.println(reader.readLine());
                }
            }
        }
    }
}

