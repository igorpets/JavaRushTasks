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
 *
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
