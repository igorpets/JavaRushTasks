package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scan.nextLine());
             FileOutputStream output = new FileOutputStream(scan.nextLine())) {
            int count = input.available();
            byte[] buffer = new byte[count];
            int read = input.read(buffer, 0, count);
            if (read > 0) {
                for (int i = count - 1; i >= 0; i--)
                    output.write(buffer[i]);
            }
        } catch (Exception e) {

        }
    }
}
