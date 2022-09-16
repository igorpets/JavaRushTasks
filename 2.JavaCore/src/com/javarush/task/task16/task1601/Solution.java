package com.javarush.task.task16.task1601;

/* 
My first thread
1. Добавь в класс Solution публичный статический класс TestThread.
2. Класс TestThread должен реализовывать интерфейс Runnable.
3. Метод run класса TestThread должен выводить "My first thread".
4. Программа должна вывести "My first thread".
5. Метод main не изменять.
*/

public class Solution {
    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }
    public static class TestThread implements Runnable{
        public void run() {
            System.out.println("My first thread");
        }
    }
}
