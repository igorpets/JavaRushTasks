package com.javarush.task.task19.task1902;

import java.io.FileOutputStream;
import java.io.IOException;

/* 
Адаптер
+1. AmigoStringWriter должен быть интерфейсом.
+2. Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
3. Класс AdapterFileOutputStream должен содержать приватное поле fileOutputStream типа FileOutputStream.
4. Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
5. Метод flush() класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу fileOutputStream.
6. Метод writeString(String s) класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу
   write() объекта fileOutputStream.
7. Метод close() класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу fileOutputStream.
*/

public class AdapterFileOutputStream implements AmigoStringWriter{

    public static void main(String[] args) {

    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void writeString(String s) throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}