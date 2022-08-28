package com.javarush.task.pro.task18.task1805;

import java.util.ArrayList;
import java.util.Collections;

/* 
Прощание с лямбда-выражением
*/

final class Solution implements TestInterface{

    public static void main(String[] args) {
        var strings = new ArrayList<String>();

        Collections.addAll(strings, "JavaRush", "Amigo", "Java Developer", "CodeGym");

        sortStringsByLength(strings);

        for (String string : strings) {
            System.out.println(string);
        }
        //short z=1.0;
        char c='\u072f';
        //String s = new String(75);
        String _int,short7;
        double z=0.5;
        short x=4;
        x= (short)(int)z;
    }
    public int test(){
        return 0;
    }

    public static void sortStringsByLength(ArrayList<String> strings) {
        Collections.sort(strings, (s1, s2) -> s1.length() - s2.length());
    }
}
