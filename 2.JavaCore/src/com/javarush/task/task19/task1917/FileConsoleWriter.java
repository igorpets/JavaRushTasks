package com.javarush.task.task19.task1917;

import java.io.*;
import java.nio.charset.Charset;

/* 
Свой FileWriter
1. +Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter, которое не должно быть сразу
   проинициализировано.
2. +Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
3. +Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException, в котором
   данные для записи должны записываться в fileWriter и дублироваться в консоль.
4. +Класс FileConsoleWriter должен содержать метод write(int c) throws IOException, в котором данные для записи
   должны записываться в fileWriter и дублироваться в консоль.
5. +Класс FileConsoleWriter должен содержать метод write(String str) throws IOException, в котором данные для
   записи должны записываться в fileWriter и дублироваться в консоль.
6. +Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException, в
   котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
7. +Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException, в котором данные для
   записи должны записываться в fileWriter и дублироваться в консоль.
8. +Класс FileConsoleWriter должен содержать метод close() throws IOException, в котором должен вызываться такой же
   метод поля fileWriter.
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public static void main(String[] args) {
        try {
            FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("output.txt");
            char[] buf = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '\n'};
            fileConsoleWriter.write(buf, 5, 6);
            fileConsoleWriter.write('A');
            fileConsoleWriter.write("\nTEST02\n");
            fileConsoleWriter.write("abcdefTEST03\n", 4, 9);
            fileConsoleWriter.close();
        } catch (Exception e) {
        }
    }

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        System.out.print(String.valueOf(cbuf, off, len));
        fileWriter.write(cbuf, off, len);
    }

    public void write(int c) throws IOException {
        System.out.print((char)c);
        fileWriter.write(c);
    }

    public void write(String str) throws IOException {
        System.out.print(str);
        fileWriter.write(str);
    }

    public void write(String str, int off, int len) throws IOException {
        System.out.print(str.substring(off, off + len));
        fileWriter.write(str, off, len);
    }

    public void write(char[] cbuf) throws IOException {
        System.out.print(cbuf);
        fileWriter.write(cbuf);
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
