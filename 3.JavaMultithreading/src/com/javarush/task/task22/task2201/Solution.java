package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        String result = "";
        try {
            if (string == null || string.length() < 2) throw new Exception();
            String[] words = string.split("\t");
            if (words.length < 3) throw new Exception();
            result = words[1];
            for (int i = 2; i < words.length - 1; i++)
                result += "\t" + words[i];
        } catch (Exception e) {
            if (threadName.equals(FIRST_THREAD_NAME))
                throw new StringForFirstThreadTooShortException(new StringIndexOutOfBoundsException("String index out of range: -1"));
            else if (threadName.equals(SECOND_THREAD_NAME))
                throw new StringForSecondThreadTooShortException(new StringIndexOutOfBoundsException("String index out of range: -1"));
            else
                throw new RuntimeException(new StringIndexOutOfBoundsException("String index out of range: -1"));
        }
        return result;
    }
}
