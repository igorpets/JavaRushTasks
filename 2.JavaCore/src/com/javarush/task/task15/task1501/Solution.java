package com.javarush.task.task15.task1501;

/* 
ООП - Расставить интерфейсы
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Movable {
        boolean isMovable();
    }

    public interface Sellable {
        Object getAllowedAction(String name);
    }

    public interface Discountable {
        Object getAllowedAction();
    }

    public static class Clothes implements Discountable, Sellable, Movable {
        public Object getAllowedAction() {
            return new Object();
        }
        public Object getAllowedAction(String name) {
            return new Object();
        }
        public boolean isMovable(){
            return true;
        }
    }
}
