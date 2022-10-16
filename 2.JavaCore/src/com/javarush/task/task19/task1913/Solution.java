package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original_out = System.out;
        ByteArrayOutputStream my_out = new ByteArrayOutputStream();
        PrintStream my_print = new PrintStream(my_out);
        System.setOut(my_print);
        testString.printSomething();
        //**********
        String orig_text = my_out.toString().replaceAll("\\D","");
        //**********
        original_out.println(orig_text);
        System.setOut(original_out);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
