package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
1. Создай 5 различных своих нитей (наследников класса Thread):
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()

1. Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
2. Нити из списка threads не должны стартовать автоматически.
3. Нить 1 из списка threads должна бесконечно выполняться.
4. Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
5. Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
6. Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
7. Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        Thread t3 = new Thread3();
        Thread t4 = new Thread4();
        Thread t5 = new Thread5();
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        threads.add(t4);
        threads.add(t5);
        //t1.start();
        //t2.start();
        //t3.start();
        //t4.start();
        //t5.start();
    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread {
        public void run() {
            while (true) try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted())
                    Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println("InterruptedException");
        }
    }

    public static class Thread3 extends Thread {
        public void run() {
            while (true) try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        public void run() {
            try {
                while (!this.isInterrupted())
                    Thread.sleep(100);
            } catch (Exception e) {
            }
        }

        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread5 extends Thread {
        public void run() {
            try (Scanner scan = new Scanner(System.in)) {
                String str = "0";
                long summ = 0;
                while (!str.equals("N")) {
                    str = scan.nextLine();
                    try {
                        summ += Long.parseLong(str);
                    } catch (Exception e) {
                    }
                }
                System.out.println(summ);
            }
        }
    }
}