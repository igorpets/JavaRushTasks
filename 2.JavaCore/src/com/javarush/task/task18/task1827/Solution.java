package com.javarush.task.task18.task1827;

import java.io.*;

import java.util.Scanner;

/* 
Прайсы
1. Программа должна считать имя файла для операций CRUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.

19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = null;
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
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            max++;
            if (max > 99999999) max = 99999999;
            try (BufferedWriter output = new BufferedWriter(new FileWriter(filename, true))) {
                if (args.length >=4 && args[0].equals("-c")) {
                    String name = args[1];
                    if (name.length() > 30) name = name.substring(0, 30);
                    String price = args[2];
                    if (price.length() > 8) price = price.substring(0, 8);
                    String count = args[3];
                    if (count.length() > 4) count = count.substring(0, 4);
                    output.write("\n" + String.format("%-8d%-30s%-8s%-4s", max, name, price, count));
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
