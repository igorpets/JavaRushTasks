package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    static public Arkanoid game;
    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    public static void main(String[] args) {

    }
    public Arkanoid(int w, int h){
        width = w;
        height = h;
    }
    public void run(){

    }
    public void move(){
        ball.move();
        stand.move();
    }
    public void draw(Canvas canvas){
        ball.draw(canvas);
        stand.draw(canvas);
        for(Brick b: bricks){
            if (b != null) {
                b.draw(canvas);
            }
        }
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public Ball getBall(){
        return ball;
    }
    public void setBall(Ball ball){
        this.ball = ball;
    }
    public Stand getStand(){
        return stand;
    }
    public void setStand(Stand stand){
        this.stand = stand;
    }
    public List<Brick> getBricks(){
        return bricks;
    }
    public void setBricks(List<Brick> bricks){
        this.bricks = bricks;
    }
}
