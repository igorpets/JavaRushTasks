package com.javarush.task.task21.task2112;

import java.io.Closeable;

/*
1. Класс FakeConnection должен поддерживать интерфейс AutoCloseable.
2. Метод close класса FakeConnection должен выводить на экран фразу "Closing database connection...".
 */
public class FakeConnection implements AutoCloseable{

    public FakeConnection() {
        System.out.println("Establishing database connection...");
    }

    public void unsupportedOperation() {
        System.out.println("Operation is not supported yet!");
        throw new RuntimeException("UnsupportedOperation!");
    }

    public void usefulOperation() {
        System.out.println("Executing useful operation.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing database connection...");
    }
}
