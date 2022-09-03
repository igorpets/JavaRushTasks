package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы CanRun, CanSwim
1. Класс Solution должен содержать интерфейс CanRun с одним методом.
2. Класс Solution должен содержать интерфейс CanSwim с одним методом.
3. Класс Solution должен содержать класс Human.
4. Класс Human должен реализовывать интерфейсы CanRun и CanSwim.
5. Класс Human должен быть абстрактным.
6. У класса Human не должно быть методов.
*/

public class Solution {
    public static void main(String[] args) {

    }

    //add public interfaces and a public class here - добавь public интерфейсы и public класс тут
    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void run();
    }

    public abstract class Human implements CanRun, CanSwim {
    }
}
