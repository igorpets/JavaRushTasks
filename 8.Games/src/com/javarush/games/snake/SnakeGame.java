package com.javarush.games.snake;

import com.javarush.engine.cell.*;

/**
 * Игра змейка
 * <p>
 * Игрок управляет движением змейки, которая ползает по квадратному полю: вверх, вниз, вправо и влево.
 * Остановить движение змейки нельзя.
 * Цель игры — съесть как можно большее количество яблок, которые появляются поочередно, в случайном
 * месте игрового поля, как только змейка "проглотит" предыдущее.
 * С каждым новым яблоком змейка растет на один сегмент (занимает на одну ячейку больше).
 * В нашей игре на старте змейка занимает три ячейки (имеет три сегмента) и может дорасти до 28.
 * По мере того, как растет змейка, скорость игры увеличивается.
 * Змейка не может проходить "сквозь себя" или выходить за пределы игрового поля.
 * Игра оканчивается победой, если длина змейки увеличилась до 28 сегментов.
 * Игра оканчивается проигрышем, если касается сама себя или края поля.
 * <p>
 * Для сборки необходимо установить VM options:
 * --module-path "C:\Projects\java\JavaRushTasks\lib\javafx-sdk-18.0.1\lib" --add-modules javafx.controls,javafx.fxml
 * <p>
 * 4.7. В методе createGame() класса SnakeGame должно быть создано новое яблоко (экземпляр класса Apple) с координатами: 7, 7.
 * 4.8. У созданного яблока должен быть вызван метод draw(Game). В качестве параметра метода передай this.
 */
public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        Apple apple = new Apple(7, 7);
        apple.draw(this);
        drawScene();
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, Color.LIGHTPINK);
            }
        }
    }

}
