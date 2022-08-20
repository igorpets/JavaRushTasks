package com.javarush.games.minesweeper;

/**
 * Типы ячеек на игровом поле с учетом их состояния.
 */
public enum CellType {
    EMPTY,
    MINE,
    OPEN_EMPTY,
    CHECKED_EMPTY,
    CHECKED_MINE
}
