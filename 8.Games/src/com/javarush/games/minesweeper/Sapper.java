package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Sapper extends Game {
    /**
     * Текст "💣" для отображения Мины на игровом поле.
     */
    private final String MINE_TXT = "\uD83D\uDCA3";
    /**
     * Текст "🚩" для отображения Флага на игровом поле.
     */
    private static final String FLAG_TXT = "\uD83D\uDEA9";
    /**
     * Начальный (минимальный) размер игрового поля.
     */
    private final int SIZE_FIRST = 10;
    /**
     * Шаг увеличения размеров игрового поля.
     */
    private final int SIZE_STEP = 5;
    /**
     * Максимальный размер игрового поля (видимое поле +1 на поля-заголовки).
     */
    private final int MAX_SIZE = 10 + SIZE_STEP * 3;
    /**
     * Смещение меню от верхнего края, для расположения "по центру".
     */
    private final int MENU_Y_OFFSET = 11;
    /**
     * Цвет ао умолчанию для нижнего поля с сообщением.
     */
    private final Color FOOTER_COLOR = Color.BROWN;

    /**
     * Выбранный текущий размер игрового поля.
     */
    private int size;
    /**
     * Размер визуального отступа сверху и слева до игрового поля.
     */
    private int area_offset = 0;
    /**
     * Число мин в текущей игре.
     */
    private int mine_count;
    /**
     * Число удачно открытых пустых ячеек, требуемое для Победы.
     */
    private int need_open_mines;
    /**
     * Результат завершения текущей игры:
     * 0 - Идет игра,
     * 1 - Победа,
     * 2 - Поражение.
     */
    private Result game_result = Result.RESULT_IN_PROGRESS;
    /**
     * Массив для хранения содержимого всех объектов (ячеек) игрового поля.
     */
    private CellObject[][] area;
    /**
     * Все поддерживаемые размеры игрового поля.
     */
    private final int[] sizes = {10, 10 + SIZE_STEP, 10 + SIZE_STEP * 2, 10 + SIZE_STEP * 3};
    /**
     * Отображаем меню с фиксированными вариантами сложности игры.
     */
    private String[] complexity_levels = {"ЛЕГКО ", "СРЕДНЕ", "СЛОЖНО", "САПЕР!"};
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
    private double scorePoints = 0.0d;
    /**
     * Базовое число для расчета очков ~= 9999/600*2,
     * 9999 - максимальное число очков,
     * 600 - максимальное число пустых ячеек.
     * 2 - средний коэффициент уменьшения базового числа за игру.
     */
    private double base_points = 33.0d;
    /**
     * Признак первого клика по игровому полю.
     */
    private boolean is_first_open = true;
    /**
     * Поле на котором стоит курсор при управлении с клавиатуры.
     */
    private CellObject cursor;

    /**
     * Входная точка в игру, вызывается из родительского класса Game.
     */
    @Override
    public void initialize() {
        showGrid(true);
        setScreenSize(MAX_SIZE + 1, MAX_SIZE + 2);
        size = sizes[0];
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
            case GAME_TEST_COLOR:
            case GAME_BLOCKED:
                stopTurnTimer();
                open_menu_size();
                break;
            case GAME_MENU_SIZE:
                open_menu_difficulty();
                break;
            case GAME_MENU_COMPL:
                minesweeper_init();
                break;
            case GAME_MAIN_FORM:
                mode = Mode.GAME_BLOCKED;
                break;
        }
    }

    /**
     * Меню выбора размера поля.
     */
    private void open_menu_size() {
        if (mode != Mode.GAME_MENU_SIZE) {
            mode = Mode.GAME_MENU_SIZE;
            clear_screen();
            show_footer("Выберите размер игры", FOOTER_COLOR);
        }
        // Отображаем меню с фиксированными вариантами игры.
        int menu_x = (getScreenWidth() - " 15x15 ".length()) / 2;
        for (int i = 0; i < sizes.length; i++) {
            int curr_size = sizes[i];
            // Полное название меню из 10 символов.
            String text_menu = " " + curr_size + "x" + curr_size + " ";
            one_menu_to_screen(menu_x, MENU_Y_OFFSET + i, text_menu, size == curr_size);
        }
    }

    /**
     * Отображение одной произвольной строки меню.
     */
    private void one_menu_to_screen(int menu_x, int menu_y, String text_menu, boolean selected) {
        if (menu_y >= getScreenHeight()) return;
        int screen_width = getScreenWidth();
        Color menu_color;
        if (selected) menu_color = Color.ANTIQUEWHITE;
        else menu_color = Color.LIGHTBLUE;
        for (int k = 0; k < text_menu.length(); k++) {
            if (menu_x + k < screen_width)
                setCellValueEx(menu_x + k, menu_y, menu_color, text_menu.substring(k, k + 1), Color.BROWN, 80);
        }
    }

    /**
     * Отображение меню выбора сложности игры.
     */
    private void open_menu_difficulty() {
        if (mode != Mode.GAME_MENU_COMPL) {
            mode = Mode.GAME_MENU_COMPL;
            clear_screen();
            show_footer("Выберите сложность игры", FOOTER_COLOR);
        }
        for (int i = 0; i < complexity_levels.length; i++) {
            one_menu_to_screen(10, MENU_Y_OFFSET + i, complexity_levels[i], complexity == i);
        }
    }

    /**
     * Выполняем все действия по инициализации игры и ее объектов.
     */
    private void minesweeper_init() {
        mode = Mode.GAME_MAIN_FORM;
        is_first_open = true;
        cursor = null;
        area = new CellObject[size][size];
        // Отображаем адресные ячейки.
        for (int m = 0; m < size; m++) {
            setCellValueEx(area_offset - 1, m + area_offset, Color.LIGHTCYAN,
                    String.valueOf(m + 1), Color.BLACK, 60);
            setCellValueEx(m + area_offset, area_offset - 1, Color.LIGHTCYAN,
                    String.valueOf(m + 1), Color.BLACK, 60);
        }
        // Инициализируем счетные параметры игры.
        CellObject.initFlagsCount();
        // Определяем количество пустых ячеек, для Победы требуется открыть их все.
        need_open_mines = size * size - mine_count;
        game_result = Result.RESULT_IN_PROGRESS;
        scorePoints = 0;
        // Базовое число очков, добавляется при каждом удачном открытии пустой ячейки, уменьшается со временем.
        base_points = 33.0d;
        setScore(get_int_points());
        // Заполняем все игровое поле пустыми ячейками (без мин и флагов).
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                CellObject obj = new CellObject(i, k);
                area[i][k] = obj;
            }
        }

        // Устанавливаем на игровое поле заданное количество мин.
        minesInstall(mine_count);

        // Отображаем все игровые ячейки size*size.
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                showCell(area[i][k]);
            }
        }
        // Отображаем число мин.
        show_count_need_to_open();

        // Запускаем таймер на снижение базовых очков (ScorePoints) каждую секунду.
        setTurnTimer(1000);
        // Начинаем игру! Теперь доступна работа мышью.
        mode = Mode.GAME_MAIN_FORM;
    }

    /**
     * Устанавливаем на игровое поле заданное количество мин.
     */
    private void minesInstall(int mine_installed) {
        // Ограничение для защиты от бесконечного цикла.
        int limit = size * size * 5;
        while (mine_installed > 0 && limit > 0) {
            int mine_x = (int) Math.round(Math.random() * (size - 1));
            int mine_y = (int) Math.round(Math.random() * (size - 1));
            CellObject obj = area[mine_x][mine_y];
            if (!obj.isMine && !obj.isOpen) {
                obj.isMine = true;
                mine_installed--;
            }
            limit--;
        }
    }

    // Отображение нового состояния ячейки на игровом поле.
    private void showCell(CellObject obj) {
        Color show_color;
        String show_type = "";
        if (obj.isOpen) {
            // Открытое поле.
            if (obj.isCursor)
                show_color = Color.TAN;
            else
                show_color = Color.ANTIQUEWHITE;
            if (obj.countMineNeighbors > 0)
                show_type = String.valueOf(obj.countMineNeighbors);
        } else {
            // Закрытое поле
            if (obj.isCursor) show_color = Color.DEEPSKYBLUE;
            else show_color = Color.LIGHTBLUE;
            // Отображаем метки на Минах.
            if (obj.getIsFlag())
                show_type = FLAG_TXT;
        }
        // Отображаем новое состояние ячейки.
        setCellValueEx(obj.x + area_offset, obj.y + area_offset, show_color, show_type, Color.BROWN, 60);
    }

    /**
     * Отображаем количество неоткрытых пустых ячеек.
     */
    private void show_count_need_to_open() {
        if (game_result == Result.RESULT_IN_PROGRESS)
            show_footer("Осталось открыть: " + need_open_mines, FOOTER_COLOR);
    }

    /**
     * Вычисляет количество мин около каждой ячейки для всего игрового поля.
     */
    private void calc_mines() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                CellObject obj = area[x][y];

                int left_x = Math.max(0, x - 1);
                int right_y = Math.min(size - 1, x + 1);
                int top_y = Math.max(0, y - 1);
                int bottom_y = Math.min(size - 1, y + 1);
                int mines_lookup = 0;
                for (int i = left_x; i <= right_y; i++) {
                    for (int k = top_y; k <= bottom_y; k++) {
                        CellObject lookup_obj = area[i][k];
                        if (lookup_obj.isMine)
                            mines_lookup++;
                    }
                }
                obj.countMineNeighbors = mines_lookup;
            }
        }
    }

    /**
     * Вычисляет количество правильно отмеченных мин для все ячеек около заданной.
     * Используется при рекурсивном раскрытии пустых полей.
     */
    private void calc_flag_mines(CellObject mine_obj) {
        int left_x = Math.max(0, mine_obj.x - 1);
        int right_y = Math.min(size - 1, mine_obj.x + 1);
        int top_y = Math.max(0, mine_obj.y - 1);
        int bottom_y = Math.min(size - 1, mine_obj.y + 1);
        for (int i = left_x; i <= right_y; i++) {
            for (int k = top_y; k <= bottom_y; k++) {
                CellObject lookup_obj = area[i][k];
                if (lookup_obj != mine_obj)
                    calc_flag_mines_by_one(lookup_obj);
            }
        }
    }

    /**
     * Внутренняя функция для расчета правильно отмеченных мин для одной ячейки.
     */
    private void calc_flag_mines_by_one(CellObject obj) {
        if (obj.isMine) return;

        int left_x = Math.max(0, obj.x - 1);
        int right_y = Math.min(size - 1, obj.x + 1);
        int top_y = Math.max(0, obj.y - 1);
        int bottom_y = Math.min(size - 1, obj.y + 1);
        int flags_mine_count = 0;
        for (int i = left_x; i <= right_y; i++) {
            for (int k = top_y; k <= bottom_y; k++) {
                CellObject lookup_obj = area[i][k];
                if (lookup_obj.isMine && lookup_obj.getIsFlag())
                    flags_mine_count++;
            }
        }
        obj.countFlagsMine = flags_mine_count;
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
                if (y >= MENU_Y_OFFSET && y <= MENU_Y_OFFSET + 3) {
                    // Варианты размеров игрового поля от 10(0) до 25(3).
                    setMenuSize(SIZE_FIRST + SIZE_STEP * (y - MENU_Y_OFFSET));
                }
                break;
            case GAME_MENU_COMPL:
                if (y >= MENU_Y_OFFSET && y <= MENU_Y_OFFSET + 3) {
                    // Определяем уровень сложности текущей игры от 0 до 3.
                    setMenuComplexity(y - MENU_Y_OFFSET);
                }
                break;
            case GAME_MAIN_FORM:
                int cell_x = x - area_offset;
                int cell_y = y - area_offset;
                if (cell_x < 0 || cell_x >= size || cell_y < 0 || cell_y >= size) return;
                setOpen(area[cell_x][cell_y]);
                break;
            case GAME_TEST_COLOR:
                Color color = getCellColor(x, y);
                String color_text = color.ordinal() + " " + color.toString();
                System.out.println(color_text);
                show_footer(color_text, FOOTER_COLOR);
                break;
            default:
                mode_switch();
                break;
        }
    }

    private void setOpen(CellObject open_obj) {
        if (is_first_open) {
            is_first_open = false;
            if (open_obj.isMine) {
                {
                    // Если это первый клик и попали на мину, то убираем ее в новое место.
                    minesInstall(1);
                    open_obj.isMine = false;
                }
            }
            // Вычисляем число соседних мин для всех пустых полей.
            calc_mines();
        }
        if (!open_obj.isOpen) {
            if (open_obj.isMine) {
                // Останавливаем игру.
                mode = Mode.GAME_BLOCKED;
                game_result = Result.RESULT_DEFEAT;
                // Отображаем взорванную мину.
                setCellValueEx(open_obj.x + area_offset, open_obj.y + area_offset,
                    Color.RED, MINE_TXT, Color.BLACK, 60);
                for (int i = 0; i < size; i++) {
                    for (int k = 0; k < size; k++) {
                        CellObject test_obj = area[i][k];
                        if (test_obj.getIsFlag() && !test_obj.isMine) {
                            // Отображаем ошибки отмеченных мин, если есть.
                            setCellValueEx(i + area_offset, k + area_offset,
                                    Color.LIGHTBLUE, "X", Color.DARKRED, 60);
                        } else if (test_obj.isMine && !test_obj.getIsFlag() && !test_obj.equals(open_obj)) {
                            // Отображаем все ненайденные мины.
                            setCellValueEx(i + area_offset, k + area_offset,
                                    Color.LIGHTBLUE, MINE_TXT, Color.DARKRED, 60);
                        }
                    }
                }
                show_footer("Вы проиграли!", Color.DARKRED);
                // При поражении делим полученные очки на 2.
                scorePoints = scorePoints / 2.0d;
                setScore(get_int_points());
            } else {
                open_by_empty(open_obj);
                show_count_need_to_open();
            }
        }
    }

    /**
     * Изменяем уровень сложности текущей игры от 0 до 3.
     */
    private void setMenuComplexity(int new_complexity) {
        complexity = new_complexity;
        // Вычисляем число мин на игровом поле, в зависимости от сложности игры.
        mine_count = size * size / (10 - complexity);
        mode_switch();
    }

    /**
     * Устанавливаем новый размер игрового поля.
     */
    private void setMenuSize(int new_size) {
        size = new_size;
        // Вычисляем смещение от края сцены.
        area_offset = (MAX_SIZE - size) / 2 + 1;
        mode_switch();
    }

    /**
     * Функция проверки условий Победы, если выполнены, то игра завершается.
     */
    private void check_victory() {
        if (need_open_mines <= 0) {
            // Победа! завершаем игру.
            mode = Mode.GAME_BLOCKED;
            game_result = Result.RESULT_VICTORY;
            show_footer("Вы  победили!", Color.DARKGREEN);
        }
    }

    /**
     * Таймер ожидания просмотра игрового поля после победы или поражения.
     */
    @Override
    public void onTurn(int step) {
        if (mode != Mode.GAME_MAIN_FORM) {
            // Останавливаем игровой таймер.
            stopTurnTimer();
            return;
        }
        if (game_result == Result.RESULT_IN_PROGRESS && mode == Mode.GAME_MAIN_FORM && !is_first_open) {
            // каждую секунду уменьшаем базовое число для выдачи новых очков.
            updateBaseIndex((size - 10) / SIZE_STEP);
        }
        setCellValueEx(area_offset - 1, area_offset - 1, Color.BLACK,
                String.valueOf(Math.round(base_points)), Color.WHITE, 60);
    }

    /**
     * Уменьшает базовое число для выдачи новых очков за открытие полей.
     */
    private void updateBaseIndex(int size_index) {
        if (base_points > 3) base_points -= 0.2d * (4 - size_index);
        else base_points *= (96.5d + 1.0d * size_index) / 100.0d;
    }

    /**
     * Рекурсивная функция открытия соседних ячеек.
     * Если выбранная ячейка пустая и число соседних мин = 0,
     * то соседние пустые тоже открываются.
     */
    private void open_by_empty(CellObject obj) {
        obj.isOpen = true;
        showCell(obj);
        // Открыли пустую ячейку, добавляем очки!
        add_points();
        if (obj.countMineNeighbors - obj.countFlagsMine > 0) return;
        // Если число рядом стоящих мин равно нулю, то открываем соседние пустые ячейки.
        int left_x = Math.max(0, obj.x - 1);
        int right_x = Math.min(size - 1, obj.x + 1);
        int top_y = Math.max(0, obj.y - 1);
        int bottom_y = Math.min(size - 1, obj.y + 1);
        for (int i = left_x; i <= right_x; i++) {
            for (int k = top_y; k <= bottom_y; k++) {
                CellObject neighbor_obj = area[i][k];
                if (!neighbor_obj.isMine && !neighbor_obj.isOpen) {
                    if (neighbor_obj.getIsFlag() && !neighbor_obj.isMine) {
                        // Корректно снимаем ошибочную метку Мины.
                        neighbor_obj.setIsFlag(false);
                        calc_flag_mines(neighbor_obj);
                    }
                    // Входим в рекурсию.
                    open_by_empty(neighbor_obj);
                }
            }
        }
    }

    /**
     * Добавляет очки за правильное открытие пустой ячейки.
     * Одновременно обновляет счетчики и проверяет условия победы.
     */
    private void add_points() {
        need_open_mines--;
        scorePoints += base_points;
        setScore(get_int_points());
        check_victory();
    }

    /**
     * Возвращает игровые очки в формате INT.
     */
    private int get_int_points() {
        return (int) Math.round(scorePoints);
    }

    /**
     * Ставим или убираем метку Мины.
     * Срабатывает только на закрытых полях.
     * Работает только в режиме GAME_MAIN_FORM.
     */
    @Override
    public void onMouseRightClick(int x, int y) {
        if (mode != Mode.GAME_MAIN_FORM) return;
        if (CellObject.getFlagsCount() >= mine_count) return;

        // Приводим визуальные координаты к нумерации внутреннего массива ячеек area[][].
        x -= area_offset;
        y -= area_offset;

        // Если нажали за пределами игрового поля, то игнорируем.
        if (x < 0 || y < 0 || x >= size || y >= size) return;

        setFlag(area[x][y]);
    }

    private void setFlag(CellObject obj) {
        // Если поле открыто, то игнорируем.
        if (obj.isOpen) return;

        // Меняем состояние метки с флагом и отображаем на игровом поле.
        obj.setIsFlag(!obj.getIsFlag());
        calc_flag_mines(obj);
        showCell(obj);
    }

    /**
     * Закрашиваем все игровое поле черным цветом.
     */
    private void clear_screen() {
        for (int i = 0; i < getScreenWidth(); i++) {
            for (int k = 0; k < getScreenHeight() - 1; k++) {
                setCellValueEx(i, k, Color.BLACK, "", Color.BLACK, 60);
            }
        }
    }

    /**
     * Выполняем переход к следующему режиму по быстрым кнопкам.
     */
    @Override
    public void onKeyPress(Key key) {
        if (key == Key.ESCAPE) {
            stopTurnTimer();
            open_menu_size();
            return;
        }
        if (key == Key.PAUSE) {
            // Отображаем панно цветов JavaRush
            mode = Mode.GAME_TEST_COLOR;
            test_all_color();
            return;
        }
        switch (mode) {
            case GAME_BLOCKED:
            case GAME_NEW:
            case GAME_TEST_COLOR:
                mode_switch();
                break;
            case GAME_MENU_SIZE:
                if (key == Key.UP && size >= SIZE_FIRST + SIZE_STEP) {
                    size -= SIZE_STEP;
                    open_menu_size();
                } else if (key == Key.DOWN && size <= SIZE_FIRST + SIZE_STEP * 2) {
                    size += SIZE_STEP;
                    open_menu_size();
                } else if (key == Key.ENTER || key == Key.SPACE) {
                    setMenuSize(size);
                }
                break;
            case GAME_MENU_COMPL:
                if (key == Key.UP && complexity >= 1) {
                    complexity--;
                    open_menu_difficulty();
                } else if (key == Key.DOWN && complexity <= 2) {
                    complexity++;
                    open_menu_difficulty();
                } else if (key == Key.ENTER || key == Key.SPACE) {
                    setMenuComplexity(complexity);
                }
                break;
            case GAME_MAIN_FORM:
                if (game_result == Result.RESULT_IN_PROGRESS)
                    game_keyboard_control(key);
                break;
        }
    }

    private void game_keyboard_control(Key key) {
        if (cursor == null) {
            // Выбираем центральное поле для курсора.
            cursor = area[size / 2][size / 2];
        }
        CellObject old_cursor = cursor;
        // Управление игрой с клавиатуры (курсор, установка флагов и открытие).
        if (key == Key.ENTER) {
            // Установка флага.
            setFlag(cursor);
        } else if (key == Key.SPACE) {
            setOpen(cursor);
        } else if (key == Key.RIGHT) {
            if (cursor.x < size - 1) {
                cursor.isCursor = false;
                cursor = area[cursor.x + 1][cursor.y];
                cursor.isCursor = true;
            }
        } else if (key == Key.LEFT) {
            if (cursor.x > 0) {
                cursor.isCursor = false;
                cursor = area[cursor.x - 1][cursor.y];
                cursor.isCursor = true;
            }
        } else if (key == Key.UP) {
            if (cursor.y > 0) {
                cursor.isCursor = false;
                cursor = area[cursor.x][cursor.y - 1];
                cursor.isCursor = true;
            }
        } else if (key == Key.DOWN) {
            if (cursor.y < size - 1) {
                cursor.isCursor = false;
                cursor = area[cursor.x][cursor.y + 1];
                cursor.isCursor = true;
            }
        }
        showCell(old_cursor);
        showCell(cursor);
    }

    private void show_footer(String footer, Color footer_color) {
        int footer_length = footer.length();
        int footer_y = getScreenHeight() - 1;
        int footer_x = (getScreenWidth() - footer_length) / 2;
        if (footer_x < 0)
            footer_x = 0;
        for (int x = 0; x < getScreenWidth(); x++) {
            String symbol = "";
            if (x >= footer_x && x < footer_x + footer_length)
                symbol = String.valueOf(footer.charAt(x - footer_x));
            setCellValueEx(x, footer_y, footer_color, symbol, Color.YELLOW, 80);
        }
    }

    private void test_all_color() {
        int x = 0;
        int y = 0;
        for (Color color : Color.values()) {
            if (color.equals(Color.NONE)) continue;
            setCellColor(x, y, color);
            setCellColor(x + 1, y, color);
            setCellColor(x + 2, y, color);
            x += 3;
            if (x > getScreenWidth() - 3) {
                x = 0;
                y++;
                if (y > getScreenHeight() - 2) {
                    System.out.println("Не влезли: " + color.ordinal());
                    break;
                }
            }
        }
    }
}
