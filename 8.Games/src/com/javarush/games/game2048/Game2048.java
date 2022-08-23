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
    private int[][] gameField = new int[SIDE][SIDE];

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
                row[m + 1] = 0;
                m++;
                result = true;
            }
        return result;
    }

    @Override
    public void onKeyPress(Key key) {
        boolean is_move = false;
        switch (key) {
            case LEFT:
                is_move = moveLeft();
                drawScene();
                break;
            case RIGHT:
                is_move = moveRight();
                drawScene();
                break;
            case UP:
                is_move = moveUp();
                drawScene();
                break;
            case DOWN:
                is_move = moveDown();
                drawScene();
                break;
        }
    }

    private boolean moveLeft() {
        boolean is_move4 = false;
        for (int y = 0; y < SIDE; y++) {
            is_move4 = compressRow(gameField[y]) || is_move4;
            boolean is_move = mergeRow(gameField[y]);
            if (is_move)
                is_move4 = compressRow(gameField[y]) || is_move || is_move4;
        }
        if (is_move4)
            createNewNumber();
        return is_move4;
    }

    private boolean moveRight() {
        rotateClockwise();
        rotateClockwise();
        boolean is_move = moveLeft();
        rotateClockwise();
        rotateClockwise();
        return is_move;
    }

    private boolean moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        boolean is_move = moveLeft();
        rotateClockwise();
        return is_move;
    }

    private boolean moveDown() {
        rotateClockwise();
        boolean is_move = moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        return is_move;
    }

    /**
     * Поворот матрицы на 90 градусов по часовой стрелке.
     */
    private void rotateClockwise() {
        for (int i = 0; i < SIDE / 2; i++) {
            for (int j = i; j < SIDE - i - 1; j++) {
                // Меняем сразу 4 элемента местами на каждом цикле по часовой стрелке.
                int temp = gameField[i][j];
                gameField[i][j] = gameField[SIDE - 1 - j][i];
                gameField[SIDE - 1 - j][i] = gameField[SIDE - 1 - i][SIDE - 1 - j];
                gameField[SIDE - 1 - i][SIDE - 1 - j] = gameField[j][SIDE - 1 - i];
                gameField[j][SIDE - 1 - i] = temp;
            }
        }
    }

    /**
     * Поворот матрицы на 90 градусов по часовой стрелке.
     */
    private void rotate180Clockwise() {
        for (int y = 0; y < (gameField.length + 1) / 2; y++) {
            for (int x = 0; x < gameField[y].length; x++) {
                // Определяем адрес парного элемента.
                int pair_y = gameField.length - 1 - y;
                int pair_x = gameField[y].length - 1 - x;
                // При достижении середины, если размер нечетный, выходим из последнего внутреннего цикла.
                if (pair_y == y && pair_x == x) break;
                // Меняем 2 элемента местами на каждом цикле.
                int temp = gameField[y][x];
                gameField[y][x] = gameField[pair_y][pair_x];
                gameField[pair_y][pair_x] = temp;
            }
        }
    }

    private void test() {
        int[][] data = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        gameField = data;

        //Rotate Matrix
        rotateClockwise();

        //Print Matrix
        printMatrix();
    }

    private void printMatrix() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

/**
 * if (key == Key.LEFT){
 * is_move = moveLeft();
 * } else if (key == Key.RIGHT) {
 * is_move = moveRight();
 * } else if (key == Key.UP) {
 * is_move = moveUp();
 * } else if (key == Key.DOWN) {
 * is_move = moveDown();
 * }
 */