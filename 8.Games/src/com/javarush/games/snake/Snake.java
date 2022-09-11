package com.javarush.games.snake;

import java.util.ArrayList;
import java.util.List;

/**
 * * 3. В классе Snake должен существовать один публичный конструктор с двумя параметрами типа int (x и y).
 * * 4. В классе Snake должно быть создано приватное поле List<GameObject> snakeParts, инициализированное при объявлении новым списком типа ArrayList<>.
 * * 5. В конструкторе должны быть созданы три объекта типа GameObject с параметрами: первый – (x, y); второй – (x + 1, y); третий – (x + 2, y).
 * * 6. Созданные в конструкторе объекты типа GameObject должны быть добавлены в список snakeParts в порядке: первый, второй, третий.
 */
public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }
}
