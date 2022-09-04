package com.javarush.task.task13.task1304;

/* 
Selectable и Updatable
1. Класс Screen должен реализовывать (implements) интерфейс Selectable.
2. Класс Screen должен реализовывать (implements) интерфейс Updatable.
3. В классе Screen должны быть реализованы методы интерфейса Selectable.
4. В классе Screen должны быть реализованы методы интерфейса Updatable.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable {
        void refresh();
    }

    //напишите тут ваш класс
    public class Screen implements Selectable, Updatable {
        public void onSelect(){

        }
        public void refresh() {

        }
    }
}
