package com.javarush.games.racer;

import com.javarush.engine.cell.*;

/**
 * Игра Racer
 * <p>
 * Цель игры — достигнуть финиша, управляя гоночной машиной на оживленной трассе.
 * Количество очков зависит от длительности гонки: чем раньше игрок финиширует, тем больше очков он получит.
 * Игра окончена, когда игрок сталкивается с другой машиной или препятствием.
 *
 * Для сборки необходимо установить VM options:
 * --module-path "C:\Projects\java\JavaRushTasks\lib\javafx-sdk-18.0.1\lib" --add-modules javafx.controls,javafx.fxml
 */

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
    }
}
