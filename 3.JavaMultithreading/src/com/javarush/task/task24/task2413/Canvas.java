package com.javarush.task.task24.task2413;
/*
1. В классе Canvas должно быть создано приватное поле width типа int.
2. В классе Canvas должно быть создано приватное поле height типа int.
3. В классе Canvas должно быть создано приватное поле matrix типа char[][].
4. В классе Canvas должен быть создан публичный геттер для поля width.
5. В классе Canvas должен быть создан публичный геттер для поля height.
6. В классе Canvas должен быть создан публичный геттер для поля matrix.
7. В классе Canvas должен быть создан публичный сеттер для поля width.
8. В классе Canvas должен быть создан публичный сеттер для поля height.
9. В классе Canvas должен быть создан публичный сеттер для поля matrix.
10. В классе Canvas должен быть создан корректный публичный конструктор с двумя параметрами типа int (width и height).
 */

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height + 2][width + 2];
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
