package com.javarush.task.task15.task1526;

/* 
Дебаг, дебаг, и еще раз дебаг
1. Программа должна выводить данные на экран.
2. Вывод на экран должен соответствовать условию задачи.
3. У метода initialize() в классе A должен быть правильный модификатор доступа.
4. Программа не должна считывать данные с клавиатуры.
*/

public class Solution {
    public static void main(String[] args) {
        new B(6);
    }

    public static class A {
        private int f1 = 7;

        public A(int f1) {
            this.f1 = f1;
            initialize();
        }

        protected void initialize() {
            System.out.println(f1);
        }
    }

    public static class B extends A {
        protected int f1 = 3;

        public B(int f1) {
            super(f1);
            this.f1 += f1;
            initialize();
        }

        protected void initialize() {
            System.out.println(f1);
        }
    }
}
