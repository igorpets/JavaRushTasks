package com.javarush.task.task21.task2113;

/*
Транзакционность
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> h = new ArrayList<>();
        h.add(new Horse("Олень", 3, 0));
        h.add(new Horse("Бегун", 3, 0));
        h.add(new Horse("Мотильда", 3, 0));
        game = new Hippodrome(h);
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            if (horse != null)
                horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            if (horse != null)
                horse.print();
        }
        for (int i = 0; i < 10; i++)
            System.out.println();
    }

    public Horse getWinner() {
        if (horses == null || horses.size() == 0) return null;
        Horse winner = null;
        for (Horse horse : horses) {
            if (winner == null || (horse != null && winner.getDistance() < horse.getDistance()))
                winner = horse;
        }
        return winner;
    }

    public void printWinner() {
        Horse winner = getWinner();
        if (winner != null)
            System.out.println("Winner is " + winner.getName() + "!");
        else
            System.out.println("Winner is Unknown!");
    }
}
