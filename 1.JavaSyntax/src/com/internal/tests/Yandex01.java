package com.internal.tests;

import java.util.ArrayList;
import java.util.Scanner;

public class Yandex01 {
    public static void main(String[] args) {
        int A;
        int B;
        while (true) {
            try (Scanner scan = new Scanner(System.in)) {
                String line = scan.nextLine();
                if (line.indexOf(' ') < 0) {
                    String[] list = line.split(" ");
                    if (list.length == 2) {
                        A = Integer.parseInt(list[0]);
                        B = Integer.parseInt(list[1]);
                        break;
                    }
                }
            }
        }
    }
}
