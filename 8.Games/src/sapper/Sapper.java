package sapper;

import com.javarush.engine.cell.*;

public class Sapper extends Game {
    /**
     * Режимы игры.
     */
    private enum Mode {
        // Новая игра
        GAME_NEW,
        // Меню выбора размера поля.
        GAME_MENU_SIZE,
        // Меню выбора сложности.
        GAME_MENU_COMPL,
        // Основаная игра - поиск мин на игровом поле.
        GAME_MAIN_FORM,
        // Временная блокировка после взрыва.
        GAME_BLOCKED,
        GAME_FINAL
    }

    /**
     * Результат игры.
     */
    private enum Result {
        RESULT_IN_PROGRESS,
        RESULT_VICTORY,
        RESULT_DEFEAT
    }

    /**
     * Типы ячеек на игровом поле с учетом их состояния.
     */
    private enum CellType {
        EMPTY,
        MINE,
        OPEN_EMPTY,
        CHECKED_EMPTY,
        CHECKED_MINE
    }

    /**
     * Текст "💣" для отображения Мины на игровом поле.
     */
    private final String MINE_TXT = "\uD83D\uDCA3";
    /**
     * Текст "🚩" для отображения Флага на игровом поле.
     */
    private static final String FLAG = "\uD83D\uDEA9";
    /**
     * Выбранный текущий размер игрового поля.
     */
    private int size;
    /**
     * Максимальный размер игрового поля (видимое поле +1 на поля-зоголовки).
     */
    private final int MAX_SIZE = 25;
    /**
     * Смещение меню от верхнего края, для расположения "по центру".
     */
    private int menu_y_offset = 11;
    /**
     * Размер визуального отступа сверху и слева до игрового поля.
     */
    private int area_offset = 0;
    /**
     * Число мин в текущей игре.
     */
    private int mine_count;
    /**
     * Число меток "Мина" на текущем игровом поле.
     */
    private int mine_checked_count;
    /**
     * Число правильно найденных мин.
     */
    private int mine_find_count;
    /**
     * Число удачно открытых пустых ячеек, требуемое для Победы.
     */
    private int need_open_empty;
    /**
     * Результат завершения текущей игры:
     * 0 - Идет игра,
     * 1 - Победа,
     * 2 - Поражение.
     */
    private Result game_result = Result.RESULT_IN_PROGRESS;
    /**
     * Массив для хранения содержимого всех ячеек игрового поля.
     */
    private CellType[][] area;
    /**
     * Текущий режим игры (меню, игра, завершение игры).
     */
    private Mode mode = Mode.GAME_NEW;
    /**
     * Выбранная сложность текущей игры.
     */
    private int complexity = 0;
    /**
     * Текущие набранные очки, не более 9999.
     */
    private double points = 0.0d;
    /**
     * Базовое число для расчета очков ~= 9999/600,
     * 9999 - максимальное число очков,
     * 600 - максимальное число пустых ячеек.
     */
    private double base_points = 16.5d;

    /**
     * Входная точка в игру, вызывается из родительского класса Game.
     */
    @Override
    public void initialize() {
        showGrid(true);
        setScreenSize(MAX_SIZE + 1, MAX_SIZE + 1);
        mode_switch();
    }

    /**
     * Переключатель текущих режимов игры.
     * GAME_NEW - новая игра.
     * GAME_MENU_SIZE - меню выбора размера игрового поля.
     * GAME_MENU_COMPL - меню выбора сложности.
     * GAME_MAIN_FORM - игра с игровым полем и минами.
     * GAME_BLOCKED - временная блокировка игры после проигрыша или победы.
     */
    private void mode_switch() {
        switch (mode) {
            case GAME_NEW:
                open_menu_size();
                break;
            case GAME_MENU_SIZE:
                open_menu_difficalty();
                break;
            case GAME_MENU_COMPL:
                minesweeper_init();
                break;
            case GAME_MAIN_FORM:
                mode = Mode.GAME_BLOCKED;
                break;
            case GAME_BLOCKED:
                show_final_message();
                break;
        }
    }

    /**
     * Меню выбора размера поля.
     */
    private void open_menu_size() {
        mode = Mode.GAME_MENU_SIZE;
        clear_screen();
        // Отображаем меню с фиксированными вариантами игры.
        String[] sizes = {"10X10", "15X15", "20X20", "25X25"};
        for (int i = 0; i < sizes.length; i++) {
            // Полное название меню из 10 символов.
            String text_menu = "ИГРА " + sizes[i];
            one_menu_to_screen(8, menu_y_offset + i, text_menu);
        }
    }

    /**
     * Отображение одной произвольной строки меню.
     */
    private void one_menu_to_screen(int menu_x, int menu_y, String text_menu) {
        Color menu_color;
        if (menu_y % 2 == 0) menu_color = Color.ANTIQUEWHITE;
        else menu_color = Color.LIGHTPINK;
        for (int k = 0; k < text_menu.length(); k++) {
            setCellValueEx(menu_x + k, menu_y, menu_color, text_menu.substring(k, k + 1), Color.BROWN, 80);
        }
    }

    /**
     * Отображение меню выбора сложности игры.
     */
    private void open_menu_difficalty() {
        mode = Mode.GAME_MENU_COMPL;
        clear_screen();
        // Отображаем меню с фиксированными вариантами сложности игры.
        String[] compl = {"ЛЕГКО ", "СРЕДНЕ", "СЛОЖНО", "САПЕР!"};
        for (int i = 0; i < compl.length; i++) {
            one_menu_to_screen(10, menu_y_offset + i, compl[i]);
        }
    }

    /**
     * Выполняем все действия по инициализации игры и ее объектов.
     */
    private void minesweeper_init() {
        System.out.println("Minesweeper_init() start...");
        mode = Mode.GAME_MAIN_FORM;
        area = new CellType[size][size];
        // Отображаем адресные ячейки.
        for (int m = 0; m < size; m++) {
            setCellValueEx(area_offset, 1 + m + area_offset, Color.LIGHTCYAN,
                    String.valueOf(m + 1), Color.BLACK, 60);
            setCellValueEx(1 + m + area_offset, area_offset, Color.LIGHTCYAN,
                    String.valueOf(m + 1), Color.BLACK, 60);
        }
        // Инициализируем счетные параметры игры.
        mine_checked_count = 0;
        mine_find_count = 0;
        // Определяем количество пустых ячеек, для Победы требуется открыть их все.
        need_open_empty = size * size - mine_count;
        game_result = Result.RESULT_IN_PROGRESS;
        points = 0;
        // Базовое число очков, добавляется при каждом удачном открытии пустой ячейки, уменьшается со временем.
        base_points = 16.5d;
        setScore(get_int_points());
        // Заполняем все игровое поле пустыми ячейками (без мин).
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                area[i][k] = CellType.EMPTY;
            }
        }

        // Устанавливаем на игровое поле заданное количество мин.
        int mine_installed = mine_count;
        while (mine_installed > 0) {
            int mine_x = (int) Math.round(Math.random() * (size - 1));
            int mine_y = (int) Math.round(Math.random() * (size - 1));
            if (area[mine_x][mine_y] == CellType.EMPTY) {
                area[mine_x][mine_y] = CellType.MINE;
                mine_installed--;
            }
        }

        // Отображаем все игровые ячейки size*size.
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                show_cell(i, k);
            }
        }
        // Для легкого уровня отображаем число мин, иначе просто закрашиваем.
        show_count_mines();

        // Запускаем таймера на снижение базовых очков (ScorePoints).
        setTurnTimer(5000);
        // Начинаем игру! Теперь доступна работа мышью.
        mode = Mode.GAME_MAIN_FORM;
    }

    // Отображение нового состояния ячейки на игровом поле.
    private int show_cell(int x, int y) {
        CellType cell_type = area[x][y];
        Color show_color;
        String show_type = "";
        // По умолчанию, количество соседних мин не известно.
        int find_mines = -1;
        if (cell_type == CellType.OPEN_EMPTY) {
            // Открытое поле.
            show_color = Color.ANTIQUEWHITE;
            find_mines = calc_mines(x, y);
            if (find_mines > 0)
                show_type = String.valueOf(find_mines);
            else
                show_type = "";
        } else {
            // Закрытое поле
            show_color = Color.LIGHTBLUE;
        }
        // Отображаем метки на Минах.
        if (cell_type == CellType.CHECKED_MINE || cell_type == CellType.CHECKED_EMPTY)
            show_type = MINE_TXT;
        int offset = 1 + area_offset;
        // Отображаем новое состояние ячейки.
        setCellValueEx(x + offset, y + offset, show_color, show_type, Color.BROWN, 60);
        return find_mines;
    }

    // Отображаем количество ненайденных мин.
    private void show_count_mines() {
        setCellValueEx(area_offset, area_offset, Color.AQUAMARINE,
                String.valueOf(mine_count - mine_checked_count), Color.RED, 50);
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

    /**
     * Открываем ячейку, если это Мина, то проигрышь и игра делает рестарт.
     * Иначе выбранное поле открывается и показывает количество соседних Мин.
     */
    @Override
    public void onMouseLeftClick(int x, int y) {
        switch (mode) {
            case GAME_NEW:
                // Просто переходим к следующему режиму игры.
                mode_switch();
                break;
            case GAME_MENU_SIZE:
                if (y >= menu_y_offset && y <= menu_y_offset + 3) {
                    // Варианты размеров игрового поля от 10 до 25.
                    int size_menu_number = y - menu_y_offset;
                    size = 10 + 5 * size_menu_number;
                    // Вычисляем смещение от края
                    area_offset = (MAX_SIZE - size) / 2;
                    mode_switch();
                }
                break;
            case GAME_MENU_COMPL:
                if (y >= menu_y_offset && y <= menu_y_offset + 3) {
                    // Определяем уровень сложности текущей игры от 0 до 3.
                    complexity = y - menu_y_offset;
                    mine_count = size * size / (8 - complexity) - 1;
                    mode_switch();
                }
                break;
            case GAME_MAIN_FORM:
                int cell_x = x - 1 - area_offset;
                int cell_y = y - 1 - area_offset;
                if (cell_x < 0 || cell_x >= size || cell_y < 0 || cell_y >= size) return;
                CellType cell_type = area[cell_x][cell_y];
                if (cell_type == CellType.EMPTY) {
                    area[cell_x][cell_y] = CellType.OPEN_EMPTY;
                    open_by_empty(cell_x, cell_y);
                    show_count_mines();
                    // Открыли пустую ячейку, добавляем очки!
                    add_points();
                } else if (cell_type == CellType.MINE) {
                    // Останавливаем игру.
                    mode = Mode.GAME_BLOCKED;
                    game_result = Result.RESULT_DEFEAT;
                    // Отображаем взорванную мину.
                    setCellValueEx(x, y, Color.RED, MINE_TXT, Color.BLACK, 60);
                    // Отображаем ошибки отмеченных мин, если есть.
                    for (int i = 0; i < size; i++) {
                        for (int k = 0; k < size; k++) {
                            if (area[i][k] == CellType.CHECKED_EMPTY) {
                                setCellValueEx(i + 1 + area_offset, k + 1 + area_offset,
                                        Color.RED, MINE_TXT, Color.BLUE, 60);
                            }
                        }
                    }
                    // Запускаем новый таймер на отображение окна "Вы проиграли!".
                    setTurnTimer(3000);
                }
                break;
        }
    }

    /**
     * Функция проверки условий Победы, если выполнены, то игра завершается.
     */
    private void check_victory() {
        if (mine_find_count >= mine_count && need_open_empty <= 0) {
            // Победа! завершаем игру.
            mode = Mode.GAME_BLOCKED;
            game_result = Result.RESULT_VICTORY;
            // Запускаем новый таймер на отображение окна "Вы победили!".
            setTurnTimer(2000);
        }
    }

    /**
     * Таймер ожидания просмотра игрового поля после победы или поражения.
     */
    @Override
    public void onTurn(int step) {
        if (game_result == Result.RESULT_IN_PROGRESS) {
            // каждые 5 секунд уменьшаем базовое число для выдачи новых очков.
            base_points = base_points * 99.0d / 100.0d;
        } else {
            stopTurnTimer();
            // Отображаем окно "Вы проиграли!" или "Вы победили!".
            mode_switch();
        }
    }

    /**
     * Рекурсивная функция отображения соседних ячеек.
     * Если выбранная ячейка пустая и число соседних мин = 0,
     * то соседние пустые тоже открываются.
     *
     * @param x,y - координаты в массиве area (0, size-1)
     */
    private void open_by_empty(int x, int y) {
        if (show_cell(x, y) != 0) return;
        int left_x = Math.max(0, x - 1);
        int right_x = Math.min(size - 1, x + 1);
        int top_y = Math.max(0, y - 1);
        int bottom_y = Math.min(size - 1, y + 1);
        for (int i = left_x; i <= right_x; i++) {
            for (int k = top_y; k <= bottom_y; k++) {
                CellType check_type = area[i][k];
                if (check_type == CellType.CHECKED_MINE) {
                    // Логическая ошибка.
                    System.out.println("Error: empty expected, mine detected X=" + i + " Y=" + k);
                } else if (check_type == CellType.CHECKED_EMPTY) {
                    // Корректно снимаем ошибочную метку Мины.
                    add_points();
                    mine_checked_count--;
                    area[i][k] = CellType.OPEN_EMPTY;
                    open_by_empty(i, k);
                } else if (check_type == CellType.EMPTY) {
                    area[i][k] = CellType.OPEN_EMPTY;
                    add_points();
                    open_by_empty(i, k);
                }
            }
        }
    }

    /**
     * Отображаем финальное сообщение о Победе или проигрыше.
     */
    private void show_final_message() {
        // Игра завершена, готовимся к рестарту.
        mode = Mode.GAME_NEW;
        clear_screen();
        int message_y = (MAX_SIZE + 1) / 2 - 2;
        if (game_result == Result.RESULT_VICTORY)
            one_menu_to_screen(5, message_y, "Вы победили!   ");
        else {
            one_menu_to_screen(5, message_y, "Вы проиграли!  ");
            // При поражении делим полученные очки на 2.
            points = points / 2.0d;
            setScore(get_int_points());
        }
        String current_points = String.valueOf(get_int_points());
        while (current_points.length() < 4) current_points = " " + current_points;
        one_menu_to_screen(5, message_y + 2, "Ваши очки: " + current_points);
    }

    /**
     * Добавляет очки за правильное открытие пустой ячейки.
     * Одновременно обновляет счетчики и проверяет условия победы.
     */
    private void add_points() {
        need_open_empty--;
        points += base_points;
        setScore(get_int_points());
        check_victory();
    }

    /**
     * Возвращает игровые очки в формате INT.
     */
    private int get_int_points() {
        return (int) Math.round(points);
    }

    /**
     * Ставим или убираем метку Мины.
     * Срабатывает только на закрытых полях, не помеченных меткой "Мина".
     * Работает только в режиме GAME_MAIN_FORM.
     */
    @Override
    public void onMouseRightClick(int x, int y) {
        if (mode != Mode.GAME_MAIN_FORM) return;
        // Если нажали за пределами игрового поля, то игнорируем.
        if (x < 1 + area_offset) return;
        if (y < 1 + area_offset) return;
        // Приводим визуальные координаты к нумерации внутреннего массива ячеек area[][].
        x -= 1 + area_offset;
        y -= 1 + area_offset;
        switch (area[x][y]) {
            case EMPTY:
                // Пустая ячейка, ставим "ошибочную" метку мины.
                if (mine_count > mine_checked_count) {
                    area[x][y] = CellType.CHECKED_EMPTY;
                    mine_checked_count++;
                }
                break;
            case MINE:
                // Ячейка-мина, ставим "правильную" метку мины.
                if (mine_count > mine_checked_count) {
                    area[x][y] = CellType.CHECKED_MINE;
                    mine_checked_count++;
                    mine_find_count++;
                    check_victory();
                }
                break;
            case CHECKED_EMPTY:
                // Снимаем отметку мины.
                area[x][y] = CellType.EMPTY;
                mine_checked_count--;
                break;
            case CHECKED_MINE:
                // Снимаем отметку мины.
                area[x][y] = CellType.MINE;
                mine_checked_count--;
                mine_find_count--;
                break;
        }
        show_cell(x, y);
        show_count_mines();
    }

    /**
     * Закрашиваем все игровое поле черным цветом.
     */
    private void clear_screen() {
        for (int i = 0; i < MAX_SIZE + 1; i++) {
            for (int k = 0; k < MAX_SIZE + 1; k++) {
                setCellValueEx(i, k, Color.BLACK, "", Color.BLACK, 60);
            }
        }
    }
}
