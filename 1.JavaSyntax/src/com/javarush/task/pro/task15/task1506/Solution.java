package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in))
        {
            List <String> lines = Files.readAllLines(Paths.get(scanner.nextLine()));
            for(String text:lines) {
                for (char symb: text.toCharArray()){
                    if (symb !=',' && symb !='.' && symb !=' ')
                        System.out.print(symb);
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}

