package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        byte[] bytes = null;

        // Готовим  поток для чтения с клавиатуры.
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            return;
        }
        // Читаем имя входного файла и его содержимое.
        while (bytes == null || bytes.length == 0) {
            System.out.print("Введите имя входного файла: ");
            try (InputStream in_stream = Files.newInputStream(Path.of(scanner.nextLine()))) {
                bytes = in_stream.readAllBytes();
            } catch (Exception e) {
                if (e.getCause() instanceof NoSuchFileException)
                    System.out.println("Нет такого файла, укажите другое имя!");
                else
                    System.out.println(e);
            }
        }
        // Переворачиваем байты.
        for(int i=0; i<bytes.length-1; i+=2){
            byte temp = bytes[i];
            bytes[i] = bytes[i+1];
            bytes[i+1] = temp;
        }

        // Читаем имя выходного файла и пишем в него массив bytes[].
        while (bytes != null && bytes.length > 0) {
            System.out.print("Введите имя выходного файла: ");
            try (OutputStream out_stream = Files.newOutputStream(Path.of(scanner.nextLine()))) {
                out_stream.write(bytes);
                bytes = null;
            } catch (IOException e) {
                if (e.getCause() instanceof NoSuchFileException)
                    System.out.println("Нет такого файла, укажите другое имя!");
                else
                    System.out.println(e);
            }
        }

    }
}

