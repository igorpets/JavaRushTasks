package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scanner.nextLine());
             BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String line;

            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}