package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
1. Программа должна считать имя файла для операций CRUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.

19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

public class Solution {
    public static void main(String[] args) {
        String filename = null;
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        try (Scanner scan = new Scanner(System.in)) {
            filename = scan.nextLine();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (filename != null) {
            int max = 0;
            try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = input.readLine()) != null) {
                    int val = Integer.parseInt(line.substring(0, 8).trim());
                    if (val > max) max = val;
                    ids.add(val);
                    data.add(line);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            // Обновляем набор данных в соответствии с параметрами.
            boolean save = false;
            if (args.length >= 5 && args[0].equals("-u")) {
                int id = Integer.parseInt(args[1]);
                if (ids.contains(id)) {
                    String name = args[2];
                    if (name.length() > 30) name = name.substring(0, 30);
                    String price = args[3];
                    if (price.length() > 8) price = price.substring(0, 8);
                    String count = args[4];
                    if (count.length() > 4) count = count.substring(0, 4);
                    data.set(ids.indexOf(id), String.format("%-8d%-30s%-8s%-4s", id, name, price, count));
                    save = true;
                }
            } else if (args.length >= 2 && args[0].equals("-d")) {
                int index = ids.indexOf(Integer.parseInt(args[1]));
                if (index >= 0) {
                    ids.remove(index);
                    data.remove(index);
                    save = true;
                }
            }
            // Если данные изменились - сохраняем новый набор данных в файл, вместо старого.
            if (save)
                try (BufferedWriter output = new BufferedWriter(new FileWriter(filename, false))) {
                    boolean ret_code = false;
                    for (String line : data) {
                        if (ret_code) output.newLine();
                        output.write(line);
                        ret_code = true;
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
        }
    }
}
