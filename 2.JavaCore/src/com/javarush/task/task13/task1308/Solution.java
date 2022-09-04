package com.javarush.task.task13.task1308;

/* 
Эй, ты там живой?

1. В классе Solution должен быть объявлен интерфейс Person.
2. В классе Solution должен быть объявлен интерфейс Presentable.
3. Интерфейс Presentable должен наследоваться от интерфейса Person.
4. В интерфейсе Person должен быть объявлен метод isAlive, который проверяет, жив человек или нет.
5. Тип возвращаемого значения метода isAlive может иметь только два значения.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    // Новый код.
    public interface Person {
        boolean isAlive();
    }
    public interface Presentable extends Person {

    }
}