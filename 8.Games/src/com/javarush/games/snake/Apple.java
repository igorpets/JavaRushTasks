package com.javarush.games.snake;

import com.javarush.engine.cell.*;

/**
 * 4.1. Должен существовать публичный класс Apple.
 * 4.2. Класс Apple должен быть наследником класса GameObject.
 * 4.3. В классе Apple должен существовать один конструктор с двумя параметрами типа int (x и y), который вызывает конструктор базового класса с параметрами x и y, используя ключевое слово super.
 * 4.4. В классе Apple должно существовать приватное статическое final поле String APPLE_SIGN, инициализированное при объявлении. Например, использовать можно UTF-16 символ яблока "\uD83C\uDF4E".
 * 4.5. В классе Apple должен существовать публичный void метод draw(Game).
 * 4.6. В методе draw(Game) должен быть вызван метод setCellValueEx(int, int, Color, String, Color, int)
 * у объекта типа Game с параметрами: x, y, Color.NONE, APPLE_SIGN, <цвет яблока>,
 * 75. (<цвет яблока> используй какой тебе нравится, например, Color.GREEN).
 * 4.9. В классе Apple должен быть импорт всего содержимого пакета com.javarush.engine.cell.
 */
public class Apple extends GameObject {
    private static final String APPLE_SIGN = "\uD83C\uDF4E";

    public Apple(int x, int y) {
        super(x, y);
    }

    public void draw(Game game) {
        game.setCellValueEx(x, y, Color.NONE, APPLE_SIGN, Color.GREEN, 75);
    }
}
