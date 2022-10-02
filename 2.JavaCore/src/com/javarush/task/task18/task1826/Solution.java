package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length < 3) return;
        String input_file_name = args[1];
        String output_file_name = args[2];
        try (FileInputStream input = new FileInputStream(input_file_name);
             FileOutputStream output = new FileOutputStream(output_file_name)) {
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            if (args[0].equals("-e")) {
                // Зашифровать
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] +=  15;
                }
            } else if (args[0].equals("-d")) {
                // Расшифровать
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] -=  15;
                }
            } else return;
            output.write(buffer);
        } catch (Exception e) {
        }
    }
}
