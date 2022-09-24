package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

/* 
Последовательный вывод файлов
1. Статический блок класса Solution должен считывать с консоли имена двух файлов и сохранять их в переменные firstFileName и secondFileName.
2. Объяви в классе Solution public static класс ReadFileThread.
3. Класс ReadFileThread должен реализовывать интерфейс ReadFileInterface.
4. Класс ReadFileThread должен быть унаследован от подходящего класса.
5. Метод run класса ReadFileThread должен считывать строки из файла, установленного методом setFileName.
   А метод getFileContent, этого же класса, должен возвращать вычитанный контент. Возвращаемое значение - это одна
   строка, состоящая из строк файла, разделенных пробелами.
6. Метод systemOutPrintln должен вызывать метод join у созданного объекта f.
7. Вывод программы должен состоять из 2х строк. Каждая строка - содержимое одного файла.
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код
    static {
        try (Scanner scan = new Scanner(System.in)) {
            firstFileName = scan.nextLine();
            secondFileName = scan.nextLine();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private String content = "";

        public void run() {
            content = "";
            if (fullFileName == null || fullFileName.equals("")) {
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(fullFileName))) {
                String line;
                while ((line = reader.readLine()) != null)
                    content += line + " ";
            } catch (Exception e) {
            }
        }

        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        public String getFileContent() {
            return content;
        }
    }
}
