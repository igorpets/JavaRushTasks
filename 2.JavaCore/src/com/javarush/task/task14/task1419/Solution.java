package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
        System.out.println("size = " + exceptions.size());
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            FileInputStream input = new FileInputStream("fsafafsdfsafas");
        } catch (IOException e) {
            exceptions.add(e);
        }
        try {
            Integer num = Integer.parseInt("fasffa");
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            int[] test = new int[10];
            for (int i = -1; i < 10; i++)
                test[i] = i;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Scanner scan = new Scanner(System.in);
            if (12 == 12)
                scan = null;
            scan.close();
        } catch (NullPointerException e) {
            exceptions.add(e);
        }
        try {
            Scanner scan = new Scanner(System.in);
            if (12 == 12)
                scan.close();
            scan.next();
        } catch (IllegalStateException e) {
            exceptions.add(e);
        }
        try {
            throw new InterruptedIOException();
        } catch (InterruptedIOException e) {
            exceptions.add(e);
        }
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int test = Integer.MAX_VALUE;
            if (2==2)
                test = -10;
            int[] arr = new int[test];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ClassNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
