package com.javarush.task.task23.task2312;

/*
1. В классе Room должна быть создана приватная переменная width типа int.
2. В классе Room должна быть создана приватная переменная height типа int.
3. В классе Room должна быть создана приватная переменная snake типа Snake.
4. В классе Room должна быть создана приватная переменная mouse типа Mouse.
5. В классе Room должен быть создан корректный публичный геттер для поля width.
6. В классе Room должен быть создан корректный публичный геттер для поля height.
7. В классе Room должен быть создан корректный публичный геттер для поля snake.
8. В классе Room должен быть создан корректный публичный геттер для поля mouse.
9. В классе Room должен быть создан корректный публичный сеттер для поля width.
10. В классе Room должен быть создан корректный публичный сеттер для поля height.
11. В классе Room должен быть создан корректный публичный сеттер для поля snake.
12. В классе Room должен быть создан корректный публичный сеттер для поля mouse.
13. В классе Room должен быть создан корректный публичный конструктор с параметрами int, int и Snake(width, height и snake).
*/
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public static void main(String[] args) {
        
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Snake getSnake(){
        return snake;
    }
    public Mouse getMouse(){
        return mouse;
    }
}
