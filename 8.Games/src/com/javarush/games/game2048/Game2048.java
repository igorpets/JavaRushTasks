package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

/**
 * Игра 2048
 * <p>
 * Правила игры:
 * <p>
 * Игровое поле имеет форму квадрата. Размер стандартного поля — 4x4 плитки. Цель игры — получить плитку номиналом 2048.
 * <p>
 * 1. В каждом раунде появляется плитка номиналом 2 (с вероятностью 90%) или 4 (с вероятностью 10%).
 * 2. Можно сдвинуть все плитки игрового поля в одну из 4 сторон, нажав соответствующую клавишу:
 * вверх, вниз, вправо или влево. Если при сдвиге две плитки одного номинала "налетают" друг на друга,
 * они "слипаются" в одну. Ее номинал равен сумме соединившихся плиток. После каждого хода на свободной
 * секции поля появляется новая плитка номиналом 2 или 4. Если при нажатии клавиши местоположение плиток
 * или их номинал не изменится, ход не совершается.
 * 3. Если в одной строчке или столбце находится более двух плиток одного номинала, при сбрасывании они слипаются
 * с той стороны, в которую были направлены. Например, находящиеся в одной строке плитки (4, 4, 4, 0) после
 * хода влево превратятся в (8, 4, 0, 0), а после хода вправо — в (0, 0, 4, 8).
 * Данная обработка неоднозначности позволяет более точно формировать стратегию игры.
 * 4. За каждое соединение игровые очки увеличиваются на номинал получившейся плитки.
 * 5. Игра заканчивается поражением, если после очередного хода невозможно совершить действие.
 * 6. Игра заканчивается победой, если на поле появится клетка номиналом 2048.
 * <p>
 * Для сборки необходимо установить VM options:
 * --module-path "C:\Projects\java\JavaRushTasks\lib\javafx-sdk-18.0.1\lib" --add-modules javafx.controls,javafx.fxml
 */
public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[4][4];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        // int test = 2;
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++) {
                //gameField[y][x] = test; test *=2;
                setCellColoredNumber(x, y, gameField[y][x]);
            }
    }

    private void createNewNumber() {
        int x, y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[y][x] != 0);
        if (getRandomNumber(10) == 9) {
            gameField[y][x] = 4;
        } else {
            gameField[y][x] = 2;
        }
    }

    private Color getColorByValue(int value) {
        // LIGHTGRAY LIGHTYELLOW LIGHTBLUE;
        switch (value) {
            case 2:
                return Color.LIGHTGREEN;
            case 4:
                return Color.LIGHTCYAN;
            case 8:
                return Color.TURQUOISE;
            case 16:
                return Color.TOMATO;
            case 32:
                return Color.VIOLET;
            case 64:
                return Color.LIGHTPINK;
            case 128:
                return Color.KHAKI;
            case 256:
                return Color.MEDIUMPURPLE;
            case 512:
                return Color.GREENYELLOW;
            case 1024:
                return Color.DEEPSKYBLUE;
            case 2048:
                return Color.GOLD;
        }
        // Серый цвет поля [0].
        return Color.IVORY;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        String txt;
        if (value == 0) txt = "";
        else txt = String.valueOf(value);
        int size_text;
        if (value < 10) size_text = 65;
        else if (value < 100) size_text = 55;
        else if (value < 1000) size_text = 45;
        else size_text = 35;
        setCellValueEx(x, y, getColorByValue(value), txt, Color.BLACK, size_text);
    }

    private boolean compressRow(int[] row) {
        boolean result = false;
        int zero_index = -1;
        for (int i = 0; i < row.length; i++)
            if (row[i] == 0) {
                zero_index = i;
                break;
            }
        if (zero_index >= 0)
            for (int k = zero_index + 1; k < row.length; k++)
                if (row[k] > 0) {
                    row[zero_index] = row[k];
                    row[k] = 0;
                    zero_index++;
                    result = true;
                }

        return result;
    }

    private boolean mergeRow(int[] row) {
        boolean result = false;
        for (int m = 0; m < row.length - 1; m++)
            if (row[m] > 0 && row[m] == row[m + 1]) {
                row[m] *= 2;
                row[m+1] = 0;
                m++;
                result = true;
            }
        return result;
    }

    @Override
    public void onKeyPress(Key key) {

        if (key == Key.LEFT){
            moveLeft();
        } else if (key == Key.RIGHT) {
            moveRight();
        } else if (key == Key.UP) {
            moveUp();
        } else if (key == Key.DOWN) {
            moveDown();
        }
    }

    private void moveLeft() {

    }
    private void moveRight() {

    }
    private void moveUp(){

    }
    private void moveDown() {

    }
}
/**
 for (int i = 0; i < SIDE; i++) {
 compressRow(gameField[i]);
 mergeRow(gameField[i]);
 }
 drawScene();

        switch (key) {
            case LEFT: moveLeft(); break;
            case RIGHT: moveRight(); break;
            case UP: moveUp(); break;
            case DOWN: moveDown(); break;
        }
  */