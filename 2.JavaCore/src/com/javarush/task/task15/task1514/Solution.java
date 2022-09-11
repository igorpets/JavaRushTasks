package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(0.5, "rr5t");
        labels.put(1.5, "rr4t");
        labels.put(2.5, "rr3t");
        labels.put(3.5, "rr2t");
        labels.put(4.5, "r1rt");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
