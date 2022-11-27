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

    public void setPoint(double x, double y, char c) {
        int xx = (int) Math.round(x);
        int yy = (int) Math.round(y);
        if (xx >= 0 && yy >= 0 && yy < matrix.length && xx < matrix[0].length)
            matrix[yy][xx] = c;
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        int xx = (int) Math.round(x);
        int yy = (int) Math.round(y);
        if (xx >= 0 && yy >= 0 && yy < this.matrix.length && xx < this.matrix[0].length) {
            int y_len = Math.min(matrix.length, this.matrix.length - yy);
            int x_len = Math.min(matrix[0].length, this.matrix[0].length - xx);
            for (int ny = 0; ny < y_len; ny++)
                for (int nx = 0; nx < x_len; nx++) {
                    if (matrix[ny][nx] != 0)
                        this.matrix[ny+yy][nx+xx] = c;
                }
        }
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
