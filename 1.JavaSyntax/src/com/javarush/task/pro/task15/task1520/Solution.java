package com.javarush.task.pro.task15.task1520;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Перемещение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        //напишите тут ваш код
        if (!Files.isDirectory(sourceDirectory)) return;
        if (Files.isRegularFile(targetDirectory)) return;
        if (targetDirectory.equals(sourceDirectory)) return;
        //напишите тут ваш код
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDirectory)) {
            for (Path next_path : stream) {
                System.out.println(next_path);
                if (Files.isRegularFile(next_path)) {
                    Path new_path = targetDirectory.resolve(next_path.getFileName());
                    Files.move(next_path, new_path);
                }
            }
        } catch (Exception e) {
        }
    }
}

