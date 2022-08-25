package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

/**
 * Игра Moon Lander
 *
 * Цель – опустить посадочный модуль на лунную поверхность. Для этого игроку нужно преодолеть притяжение Луны,
 * используя кормовой ускоритель для замедления падения и боковые ускорители для перемещения корабля влево или вправо.
 * Рельеф у местности ухабистый, и есть всего одна плоская область для мягкой посадки — «платформа».
 * Если игрок успешно совершает посадку, он выигрывает.
 * Количество очков зависит от длительности посадки: чем дольше игрок совершает посадку,
 * тем меньше очков он получит в итоге.
 * Игра окончена, когда игрок разбивается о поверхность Луны.
 *
 * Для сборки необходимо установить VM options:
 * --module-path "C:\Projects\java\JavaRushTasks\lib\javafx-sdk-18.0.1\lib" --add-modules javafx.controls,javafx.fxml
 */
public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame(){
        drawScene();
    }

    private void drawScene(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, Color.LIGHTPINK);
            }
        }
    }
}
