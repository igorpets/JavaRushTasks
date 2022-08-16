package com.javarush.task.pro.task11.task1109;

/* 
Объекты внутренних и вложенных классов
*/

public class Outer {
    public Outer(){
        System.out.println("Создание объекта класса Outer");
    }
    class Inner {
        Inner() {
            System.out.println("Создание объекта внутреннего класса Inner");
        }
    }
    static class Nested {
        Nested() {
            System.out.println("Создание объекта вложенного класса Nested");
        }
    }
}
