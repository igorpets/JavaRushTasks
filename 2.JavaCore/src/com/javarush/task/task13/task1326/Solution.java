package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scanner.nextLine());
             BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String line;
            ArrayList<Integer> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                Integer val = null;
                try {
                    val = Integer.valueOf(line);
                } catch (Exception e) {
                    continue;
                }
                if (Math.abs(val) % 2 == 0)
                    list.add(val);
            }
            list.sort((a,b)->a-b);
            for (Integer num: list) {
                System.out.println(num);
            }
        } catch (Exception e) {

        }
    }
}
