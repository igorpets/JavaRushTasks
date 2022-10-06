package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String line;
            while (!(line = scan.nextLine()).equals("exit")) {
                if (!line.equals(""))
                    new ReadThread(line).run();
            }
        }
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try (FileInputStream input = new FileInputStream(fileName)) {
                int avail = input.available();
                if (avail > 0) {
                    int[] counts = new int[256];
                    byte[] buffer = new byte[avail];
                    int max = -1;
                    int max_byte = -1;
                    if (input.read(buffer) == avail) {
                        for (byte sym : buffer)
                            counts[sym + 128]++;
                        System.out.println();
                        for (int i = 0; i < counts.length; i++)
                            if (max < counts[i]) {
                                max = counts[i];
                                max_byte = i;
                            }
                        synchronized (ReadThread.class) {
                            resultMap.put(fileName, max_byte - 128);
                            //resultMap.forEach((key, value) -> System.out.println(key + " " + value + String.valueOf((char) value.byteValue())));
                        }
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }
}
