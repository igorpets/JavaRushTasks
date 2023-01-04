package com.javarush.task.task23.task2312;

/*
1. В методе main класса Room должна быть создана новая змея(объект типа Snake).
2. В методе main класса Room должно быть инициализировано поле game.
3. В методе main класса Room направление движения змеи должно быть установлено равным SnakeDirection.DOWN.
4. В классе Room должен быть создан метод run(), тип возвращаемого значения void.
5. В классе Room должен быть создан метод print(), тип возвращаемого значения void.
6. В классе Room должно быть создано статическое неприватное поле game типа Room.
*/
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public static void main(String[] args) {

    }

    public Room(int width, int height, Snake snake){
        this.width = width;
        this.height = height;
        this.snake = snake;
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
}
