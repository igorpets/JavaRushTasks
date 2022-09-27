package com.javarush.task.task17.task1714;

public class Beach_test {
    public static void main(String[] args) {
        Beach b1 = new Beach("Лазурный", 300.5f, 4);
        Beach b2 = new Beach("Морской", 207.1f, 2);
        Beach b3 = new Beach("Песочный", 300.5f, 3);
        Beach b4 = new Beach("Детское село", 207.1f, 3);
        System.out.println(b1.compareTo(b2));
        System.out.println(b2.compareTo(b1));
        System.out.println(b3.compareTo(b4));
        System.out.println(b4.compareTo(b3));
    }
}
