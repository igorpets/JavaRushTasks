package com.javarush.task.task13.task1323;

/* 
Интерфейс Updatable в классе Screen
1. Интерфейс Updatable должен наследовать (extends) интерфейс Selectable.
2. Класс Screen должен реализовывать (implements) интерфейс Updatable.
3. В классе Screen должен быть реализован метод onSelect интерфейса Selectable.
4. В классе Screen должен быть реализован метод refresh интерфейса Updatable.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    class Screen implements Updatable {
        public void onSelect(){}
        public void refresh(){}
    }
}
