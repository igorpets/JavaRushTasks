package com.javarush.task.task14.task1410;

/* 
Дегустация вин
1.	Абстрактный класс Drink должен быть создан в отдельном файле.
2.	В классе Drink должен быть реализован метод public void taste(), который выводит на экран строку - &quot;Вкусно&quot;.
3.	Класс Wine должен быть создан в отдельном файле и быть потомком класса Drink.
4.	В классе Wine должен быть реализован метод public String getHolidayName(), который возвращает строку - &quot;День Рождения&quot;.
5.	Класс SparklingWine должен быть создан в отдельном файле и быть потомком класса Wine.
6.	В классе SparklingWine должен быть реализован метод public String getHolidayName(), который возвращает строку - &quot;Новый Год&quot;.
7.	В классе Solution должен быть реализован метод getDeliciousDrink(), который возвращает объект типа Wine.
8.	В классе Solution должен быть реализован метод getWine(), который возвращает объект типа Wine.
9.	В классе Solution должен быть реализован метод getSparklingWine(), который возвращает объект типа SparklingWine.
*/

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getSparklingWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {
        return new Wine();
    }

    public static Wine getWine() {
        return new Wine();
    }

    public static Wine getSparklingWine() {
        return new Wine();
    }
}
