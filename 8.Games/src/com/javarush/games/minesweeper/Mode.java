package com.javarush.games.minesweeper;

/**
 * Режимы игры.
 */
public enum Mode {
    // Новая игра
    GAME_NEW,
    // Меню выбора размера поля.
    GAME_MENU_SIZE,
    // Меню выбора сложности.
    GAME_MENU_COMPL,
    // Основаная игра - поиск мин на игровом поле.
    GAME_MAIN_FORM,
    // Временная блокировка после взрыва.
    GAME_BLOCKED
}
