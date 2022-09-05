package com.javarush.games.racer;

import com.javarush.engine.cell.*;

/**
 * Игра Racer
 * <p>
 * Цель игры — достигнуть финиша, управляя гоночной машиной на оживленной трассе.
 * Количество очков зависит от длительности гонки: чем раньше игрок финиширует, тем больше очков он получит.
 * Игра окончена, когда игрок сталкивается с другой машиной или препятствием.
 * <p>
 * Для сборки необходимо установить VM options:
 * --module-path "C:\Projects\java\JavaRushTasks\lib\javafx-sdk-18.0.1\lib" --add-modules javafx.controls,javafx.fxml
 * <p>
 * 1. В классе RacerGame должен быть переопределен метод setCellColor(int, int, Color) родительского класса Game.
 * 2. В методе setCellColor(int, int, Color), если параметр метода x находится за пределами поля, метод не должен ничего делать.
 * 3. В методе setCellColor(int, int, Color), если параметр метода y находится за пределами поля, метод не должен ничего делать.
 * 4. В методе setCellColor(int, int, Color) должен вызываться метод базового класса, используя ключевое слово super.
 */

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    static public final int CENTER_X = WIDTH / 2;
    static public final int ROADSIDE_WIDTH = 14;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        showGrid(false);
        createGame();
    }

    // Переопределяем метод базового класса, дополнив его проверкой координат.
    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT)
            super.setCellColor(x, y, color);
    }

    private void createGame() {
        drawScene();
    }

    private void drawScene() {
        drawField();
    }

    private void drawField() {
        for (int x = 0; x < WIDTH; x++)
            for (int y = 0; y < HEIGHT; y++) {
                if (x == CENTER_X) {
                    setCellColor(x, y, Color.WHITE);
                } else if (x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH) {
                    setCellColor(x, y, Color.DIMGREY);
                } else {
                    setCellColor(x, y, Color.GREEN);
                }
            }
    }
}
