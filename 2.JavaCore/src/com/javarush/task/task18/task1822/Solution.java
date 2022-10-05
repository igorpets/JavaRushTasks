package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length < 1) return;
        try (Scanner scan = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new FileReader(scan.nextLine()))) {
            String target = args[0]+" ";
            String line;
            do {
                line = reader.readLine();
            } while (!line.startsWith(target));
            if (line.startsWith(target))
                System.out.println(line);
        } catch (Exception e) {}
    }
}
