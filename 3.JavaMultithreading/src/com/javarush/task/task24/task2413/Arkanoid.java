package com.javarush.task.task24.task2413;

import java.util.ArrayList;
import java.util.List;

/*
1. В классе Arkanoid должен быть реализован метод checkBricksBump() в соответствии с условием задачи.
2. В классе Arkanoid должен быть реализован метод checkStandBump() в соответствии с условием задачи.
3. В классе Arkanoid должно быть создано приватное поле isGameOver типа boolean.
4. В классе Arkanoid должен быть реализован метод checkEndGame() в соответствии с условием задачи.
 */
public class Arkanoid {
    static public Arkanoid game;
    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    private boolean isGameOver;
    public static void main(String[] args) {

    }
    public Arkanoid(int w, int h){
        width = w;
        height = h;
        isGameOver = false;
    }
    // надо проверить - не столкнулся ли шарик с каким-нибудь из "кирпичей"
    public void checkBricksBump(){
        for (Brick b:  new ArrayList<>(bricks)){
            if (b.intersects(ball)){
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                bricks.remove(b);
            }
        }
    }

    // надо проверить - не ударился ли шарик о подставку
    public void checkStandBump(){
        if (ball.intersects(stand)){
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }
    public void checkEndGame(){
        // Если координата y шарика больше чем высота поля игры (height), значит шарик улетел вниз за границу экрана.
        if (ball.y > height){
            isGameOver = true;
        }
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
