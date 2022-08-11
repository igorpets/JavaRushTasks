package com.javarush.task.pro.task10.task1008;

/* 
Зарплата
*/

public class Programmer {
    private int salary = 1000;

    //напишите тут ваш код
    public int getSalary(){
        return salary;
    }
    public void setSalary(int new_salary) {
        if (new_salary > salary)
            salary = new_salary;
    }
}
