package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        if (!Files.isDirectory(sourceDirectory)) return;
        if (Files.isRegularFile(targetDirectory)) return;
        if (targetDirectory.equals(sourceDirectory)) return;
        //напишите тут ваш код
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDirectory)) {
            for (Path next_path : stream) {
                if (Files.isRegularFile(next_path)) {
                    Path new_path = targetDirectory.resolve(next_path.getFileName());
                    Files.copy(next_path, new_path);
                }
            }
        }
    }
}

