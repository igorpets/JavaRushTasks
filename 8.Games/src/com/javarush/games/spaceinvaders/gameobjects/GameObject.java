package com.javarush.games.spaceinvaders.gameobjects;

/**
 * 3. В классе GameObject должно существовать публичное поле x типа double.
 * 4. В классе GameObject должно существовать публичное поле y типа double.
 * 5. В классе GameObject должен существовать публичный конструктор с двумя параметрами типа double,
 *    который устанавливает соответствующие значения полям x и y.
 * */
public class GameObject {
    double x;
    double y;

    public GameObject(int _x, int _y){
        x = _x;
        y = _y;
    }
}
