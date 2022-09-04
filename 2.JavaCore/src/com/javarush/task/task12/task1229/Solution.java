package com.javarush.task.task12.task1229;

/* 
Родитель класса CTO
1. Класс Solution должен содержать интерфейс Businessman с методом void workHard().
2. Класс Solution должен содержать не абстрактный класс CTO.
3. Класс CTO должен реализовывать интерфейс Businessman.
4. Класс CTO не должен содержать методов.
5. Класс Solution должен содержать дополнительный класс.
6. Класс CTO должен наследоваться от дополнительного класса.
7. Дополнительный класс должен содержать один метод.
*/

public class Solution {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }

    public static class Owner {
        public void workHard(){
            System.out.println("HARD!");
        }
    }
    public static class CTO extends Owner implements Businessman {

    }
}
