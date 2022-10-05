package com.javarush.task.task18.task1821;

import java.io.FileInputStream;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length < 1) return;
        try (FileInputStream input = new FileInputStream(args[0])) {
            int[] counts = new int[256];
            byte[] data = new byte[input.available()];
            input.read(data);
            for (byte sym : data) {
                counts[sym] += 1;
            }
            for (int i = 1; i < counts.length; i++) {
                char chr = (char) i;
                int count = counts[i];
                if (count > 0)
                    System.out.println(chr + " " + count);
            }
        } catch (
                Exception e) {

        }
    }
}
