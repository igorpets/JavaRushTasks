package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Иван Иванов", 23.3d);
        grades.put("Петр Кирилов", 12.3d);
        grades.put("Константин Петров", 32.4d);
        grades.put("Максим Ле", 10.6d);
        grades.put("Мак Сим", 25.1d);
    }
}
