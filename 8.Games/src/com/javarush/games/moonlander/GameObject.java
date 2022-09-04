package com.javarush.games.moonlander;

/**
 * 4.1. В классе GameObject должно существовать публичное поле matrix типа int[][].
 * 4.2. В классе GameObject конструктор, который принимает 2 параметра типа double, должен быть удален.
 * 4.3. В классе GameObject должен появиться публичный конструктор с тремя параметрами: double, double, int[][],
 *      который устанавливает соответствующие значения полям x, y и полю matrix.
 * 4.4. В классе GameObject должен существовать только один конструктор.
 * */
public class GameObject {
    public int[][] matrix;

    public double x;
    public double y;
    public GameObject(double _x, double _y, int[][] _matrix) {
        x = _x;
        y = _y;
        matrix = _matrix;
    }
}
