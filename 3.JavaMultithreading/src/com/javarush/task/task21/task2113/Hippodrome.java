package com.javarush.task.task21.task2113;

/*
Транзакционность
 */
import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;
    public static void main(String[] args) {
        List<Horse> h = new ArrayList<>();
        h.add(new Horse("Олень", 3, 0));
        h.add(new Horse("Бегун>", 3, 0));
        h.add(new Horse("Мотильда", 3, 0));
        game = new Hippodrome(h);
    }
    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }
    public List<Horse> getHorses(){
        return horses;
    }
    public void run(){

    }
    public void move(){

    }
    public void print(){

    }
}
