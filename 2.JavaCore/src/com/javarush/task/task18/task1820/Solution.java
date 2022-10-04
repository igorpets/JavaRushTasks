package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/* 
Округление чисел
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new FileReader(scan.nextLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(scan.nextLine()))) {
            /*String line;
            ArrayList<String> data = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (!line.equals("")) {
                    data.addAll(Arrays.stream(line.split(" ")).toList());
                }
            }*/
            //writer.write(data.stream().mapToDouble(value->Double.parseDouble(value)).);
            String numbers = reader.
                    lines().
                    flatMap(x -> Arrays.stream(x.split(" "))).
                    mapToInt(value -> Math.round(Float.parseFloat(value))).
                    mapToObj(String::valueOf).
                    collect(joining(" "));

            writer.write(numbers);
        } catch (Exception e) {

        }

    }
}
