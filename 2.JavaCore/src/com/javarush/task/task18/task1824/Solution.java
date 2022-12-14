package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.Scanner;

/* 
Файлы и исключения
1. Программа должна считывать имена файлов с консоли.
2. Для каждого файла нужно создавать поток для чтения.
3. Если файл не существует, программа должна перехватывать исключение FileNotFoundException.
4. После перехвата исключения, программа должна вывести имя файла в консоль и завершить работу.
5. Потоки для чтения из файла должны быть закрыты.
6. Команду "System.exit();" использовать нельзя.
*/

public class Solution {
    public static void main(String[] args) {
        String fname="";
        FileReader reader = null;
        try (Scanner scan = new Scanner(System.in)){
            while(true) {
                fname = scan.nextLine();
                reader = new FileReader(fname);
                reader.close();
            }
        } catch (FileNotFoundException e1){
            System.out.println(fname);
            if (reader != null)
                try {
                    reader.close();
                } catch (Exception e) {}
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
