package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class MinesweeperGame extends Game {
    enum CellType {
        EMPTY,
        MINE,
        OPEN_EMPTY,
        CHECKED_EMPTY,
        CHECKED_MINE
    }

    final int size = 12;
    final int mine_count = size * size / 4;
    int mine_checked_count;
    CellType[][] area = new CellType[12][12];

    @Override
    public void initialize() {
        mine_checked_count = 0;
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                area[i][k] = CellType.EMPTY;
            }
        }
        int mine_installed = mine_count;

        while (mine_installed > 0) {
            int mine_x = (int) Math.round(Math.random() * (size - 1));
            int mine_y = (int) Math.round(Math.random() * (size - 1));
            if (area[mine_x][mine_y] == CellType.EMPTY) {
                area[mine_x][mine_y] = CellType.MINE;
                mine_installed--;
            }
        }

        //  Тут выполняем все действия по инициализации игры и ее объектов
        setScreenSize(size + 1, size + 1);
        showGrid(true);
        // Отображаем все игровые ячейки size*size.
        for (int m = 0; m < size; m++) {
            setCellValueEx(0, 1 + m, Color.LIGHTCYAN, String.valueOf(m + 1), Color.BLACK, 60);
            setCellValueEx(1 + m, 0, Color.LIGHTCYAN, String.valueOf(m + 1), Color.BLACK, 60);
        }
        show_count_mines();
        // Отображаем все игровые ячейки size*size.
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                show_cell(i, k);
            }
        }
    }

    private void show_cell(int x, int y) {
        CellType cell_type = area[x][y];
        Color show_color;
        String show_type;
        if (cell_type == CellType.EMPTY || cell_type == CellType.MINE)
            show_color = Color.LIGHTBLUE;
        else
            show_color = Color.ANTIQUEWHITE;
        if (cell_type == CellType.MINE || cell_type == CellType.CHECKED_MINE)
            show_type = "*";
        else
            show_type = String.valueOf(calc_mines(x, y));
        // Отображаем новое состояние ячейки.
        setCellValueEx(x + 1, y + 1, show_color, show_type, Color.BROWN, 80);
    }

    // Отображаем количество ненайденных мин.
    private void show_count_mines() {
        setCellValueEx(0, 0, Color.AQUAMARINE, String.valueOf(mine_checked_count), Color.RED, 40);
    }

    /**
     * Вычисляет количество мин около выбранной ячейки.
     */
    private int calc_mines(int x, int y) {
        int left_x = Math.max(0, x - 1);
        int right_y = Math.min(size - 1, x + 1);
        int top_y = Math.max(0, y - 1);
        int bottom_y = Math.min(size - 1, y + 1);
        int mines_lookup = 0;
        for (int i = left_x; i <= right_y; i++) {
            for (int k = top_y; k <= bottom_y; k++) {
                CellType check_type = area[i][k];
                if (check_type == CellType.MINE || check_type == CellType.CHECKED_MINE)
                    mines_lookup++;
            }
        }
        return mines_lookup;
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        // Открываем ячейку.
        CellType cell_type = area[x][y];
        if (cell_type == CellType.EMPTY) {
            area[x][y] = CellType.OPEN_EMPTY;
            show_cell(x, y);
        } else
        // Ставим символ "X" в клетку по которой кликнули левой кнопкой мыши
        setCellValue(x, y, "X");
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        // Ставим или убираем метку Мины.
        if (x < 1) return;
        if (y < 1) return;

        CellType cell_type = area[x][y];
        switch (area[x][y]) {
            case EMPTY:
                area[x][y] = CellType.CHECKED_EMPTY;
                mine_checked_count++;
                break;
            case MINE:
                area[x][y] = CellType.CHECKED_MINE;
                mine_checked_count++;
                break;
            case CHECKED_EMPTY:
                area[x][y] = CellType.EMPTY;
                mine_checked_count--;
                break;
            case CHECKED_MINE:
                area[x][y] = CellType.MINE;
                mine_checked_count--;
                break;
        }
        show_cell(x - 1, y - 1);
        show_count_mines();
        // Очищаем клетку по которой кликнули правой кнопкой мыши
        setCellValue(x, y, "Х");
    }
}
