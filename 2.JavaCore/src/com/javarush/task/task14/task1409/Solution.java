package com.javarush.task.task14.task1409;

/* 
Мосты
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }

    //add println method here
    public static void println(SuspensionBridge bridge) {
        System.out.println();
    }

    public static class WaterBridge extends SuspensionBridge {

    }
    public static class SuspensionBridge {

    }
}

