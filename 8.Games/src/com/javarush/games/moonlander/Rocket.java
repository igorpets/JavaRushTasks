package com.javarush.games.moonlander;

/**
 * 4.5. Должен существовать публичный класс Rocket.
 * 4.6. Класс Rocket должен быть наследником класса GameObject.
 * 4.7. В классе Rocket должен существовать один публичный конструктор с двумя параметрами типа double (x и y),
 *      который вызывает конструктор базового класса с параметрами x, y и ShapeMatrix.ROCKET,
 *      используя ключевое слово "super".
 */
public class Rocket extends GameObject{
    public Rocket(double x, double y) {
        super(x, y, ShapeMatrix.ROCKET);
    }
}
