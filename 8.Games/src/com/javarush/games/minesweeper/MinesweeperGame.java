package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    /**
     * Максимальный размер игрового поля (видимое поле +1 на поля-зоголовки).
     */
    private static final int SIDE = 9;
    private int countMinesOnField = 0;
    /**
     * Массив для хранения содержимого всех ячеек игрового поля.
     */
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    /**
     * Текст "💣" для отображения Мины на игровом поле.
     */
    private final String MINE_TXT = "\uD83D\uDCA3";

    /**
     * Входная точка в игру, вызывается из родительского класса Game.
     */
    @Override
    public void initialize() {
        createGame();
    }

    private void createGame() {
        showGrid(true);
        setScreenSize(SIDE, SIDE);
        countMinesOnField = 0;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean is_mine;
                if (getRandomNumber(10) <= 0) is_mine = true;
                else is_mine = false;
                gameField[y][x] = new GameObject(x, y, is_mine);
                if (is_mine) {
                    countMinesOnField++;
                    setCellValueEx(x, y, Color.LIGHTCYAN, MINE_TXT, Color.BLACK, 50);
                } else {
                    setCellValueEx(x, y, Color.LIGHTCYAN, "", Color.BLACK, 50);
                }
            }
        }
    }

    /**
     * Закрашиваем все игровое поле черным цветом.
     */
    private void clear_screen() {
        for (int i = 0; i < SIDE + 1; i++) {
            for (int k = 0; k < SIDE + 1; k++) {
                setCellValueEx(i, k, Color.BLACK, "", Color.BLACK, 60);
            }
        }
    }
}
