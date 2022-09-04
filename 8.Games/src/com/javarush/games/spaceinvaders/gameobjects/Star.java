package com.javarush.games.spaceinvaders.gameobjects;

/**
 * 3.6. В пакете gameobjects в отдельном файле должен существовать публичный класс Star.
 * 3.7. Класс Star должен быть наследником класса GameObject.
 * 3.8. В классе Star должен существовать публичный конструктор с двумя параметрами типа double,
 *      который вызывает конструктор базового класса с этими же параметрами.
 */
public class Star extends GameObject {
    public Star(int _x, int _y){
        super(_x, _y);
    }
}
