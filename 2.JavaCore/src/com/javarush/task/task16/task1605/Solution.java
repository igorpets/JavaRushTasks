package com.javarush.task.task16.task1605;

import java.util.Date;

/* 
Поговорим о музыке
1. Класс Violin не должен быть унаследован от какого-либо дополнительного класса.
2. Класс Violin должен реализовывать интерфейс MusicalInstrument.
3. Метод run класса Violin должен вызывать метод startPlaying.
4. Метод run класса Violin должен вызывать метод sleepNSeconds с параметром 1 секунда.
5. Метод run класса Violin должен вызывать метод stopPlaying.
6. Метод run класса Violin должен выводить на консоль продолжительность игры в миллисекундах. Используй формат из примера.

1. Считай время начала игры - метод startPlaying().
2. Подожди 1 секунду - метод sleepNSeconds(int n), где n - количество секунд.
3. Считай время окончания игры - метод stopPlaying().
4. Выведи на консоль продолжительность игры в миллисекундах. Используй методы из пунктов 2.1 и 2.3.
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument{
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " is starting to play");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " is stopping playing");
            return new Date();
        }
        public void run(){
            Date start = startPlaying();
            sleepNSeconds(1);
            Date stop = stopPlaying();
            long res = stop.getTime() - start.getTime();
            System.out.println( "Playing "+res+ " ms");
        }
    }
}
