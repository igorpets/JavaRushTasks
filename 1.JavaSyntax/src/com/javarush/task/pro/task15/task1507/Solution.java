package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in))
        {
            List <String> lines = Files.readAllLines(Paths.get(scanner.nextLine()));
            boolean flag = true;
            for(String text:lines) {
                if (flag) System.out.println(text);
                flag = !flag;
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}

