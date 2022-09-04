package com.javarush.task.task13.task1301;

/* 
Пиво
1. Класс BeerLover должен реализовывать(implements) интерфейс Alcoholic.
2. Класс BeerLover не должен реализовывать интерфейс Drinker напрямую (только опосредованно - через Alcoholic)
3. В классе BeerLover должны быть реализованы все методы интерфейса Alcoholic.
4. В классе BeerLover должны быть реализованы все методы интерфейса Drinker.
5. Метод isReadyToGoHome должен возвращать значение переменной READY_TO_GO_HOME.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Drinker {
        void askForMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcoholic extends Drinker {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();
    }

    public static class BeerLover implements Alcoholic {
        public void sleepOnTheFloor(){
            System.out.println("BeerLover->Alcoholic->sleepOnTheFloor()");
        }
        public void askForMore(String message){
            System.out.println("BeerLover->Drinker->askForMore()");
        }

        public void sayThankYou(){
            System.out.println("BeerLover->Drinker->sayThankYou()");
        }

        public boolean isReadyToGoHome(){
            return READY_TO_GO_HOME;
        }
    }
}
