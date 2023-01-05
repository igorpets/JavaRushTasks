package com.javarush.task.task23.task2312;

/**
 1. В методе main класса Room должен быть вызван метод createMouse на объекте типа Room.
 2. В методе main класса Room должен быть вызван метод run на объекте типа Room.
 3. В классе Room должен быть создан метод sleep без параметров.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    public static Room game;

    public static void main(String[] args) {
        game = new Room(10,10, new Snake(5,5));
        game.getSnake().setDirection(SnakeDirection.DOWN);
    }

    public Room(int width, int height, Snake snake){
        this.width = width;
        this.height = height;
        this.snake = snake;
    }
    public void createMouse(){
        mouse = new Mouse((int)(Math.random()*width), (int)(Math.random()*height));
    }
    public void eatMouse(){
        createMouse();
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
    public void print(){

    }
    public void run(){

    }
}
