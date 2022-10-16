package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length < 1) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            TreeMap<String, Double> data = new TreeMap<>();
            String line;
            double max = Double.MIN_VALUE;
            while ((line = reader.readLine()) != null) {
                if (!line.equals("")) {
                    String[] params = line.split(" ");
                    if (params.length >= 2) {
                        double val = Double.parseDouble(params[1]);
                        String name = params[0];
                        if (data.containsKey(name)) {
                            val = data.get(name) + val;
                            data.replace(name, val);
                        } else
                            data.put(name, val);
                        if (max < val)
                            max = val;
                    }
                }
            }

            /* Map.Entry<String, Double> entry = data.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue(Double::compareTo))
                    .get();
            System.out.println(entry.getKey());*/
            String space = "";
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                if (entry.getValue() >= max) {
                    System.out.print(space + entry.getKey());
                    space = " ";
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
