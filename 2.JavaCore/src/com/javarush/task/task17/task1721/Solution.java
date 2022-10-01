package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
1. +Класс Solution должен содержать public static поле allLines типа List<String>.
2. +Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
3. +Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. +Программа должна считывать c консоли имена двух файлов.
5. +Программа должна считывать построчно данные из первого файла в список allLines.
6. +Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. +Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. +Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. +Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution sol = new Solution();
        try (Scanner scan = new Scanner(System.in);
             BufferedReader reader1 = new BufferedReader(new FileReader(scan.nextLine()));
             BufferedReader reader2 = new BufferedReader(new FileReader(scan.nextLine()))) {
            String line;
            while ((line = reader1.readLine()) != null) {
                allLines.add(line);
            }
            while ((line = reader2.readLine()) != null) {
                forRemoveLines.add(line);
            }
            sol.joinData();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            return;
        }

        if (allLines.size() > 0) {
            while (allLines.size() > 0)
                allLines.remove(0);
            throw new CorruptedDataException();
        }
    }
}
