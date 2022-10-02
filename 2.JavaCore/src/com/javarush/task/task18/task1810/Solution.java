package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
DownloadException
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        FileInputStream input = null;
        int count = 2000;
        try (Scanner scan = new Scanner(System.in)) {
            do {
                input = new FileInputStream(scan.nextLine());
                count = input.available();
                input.close();
            } while (count >= 1000);

        } catch (Exception e) {
            try {
                if (input != null)
                    input.close();
            } catch (Exception e1) {
            }
        }
        if (count < 1000) throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
