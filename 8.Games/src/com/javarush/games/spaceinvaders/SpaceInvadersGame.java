package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

/**
 * */
public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createStars(){
        stars = new ArrayList<Star>();
        stars.add(new Star(5, 55));
        stars.add(new Star(12, 25));
        stars.add(new Star(15, 42));
        stars.add(new Star(18, 6));
        stars.add(new Star(26, 35));
        stars.add(new Star(35, 61));
        stars.add(new Star(47, 18));
        stars.add(new Star(58, 48));
    }

    private void createGame(){
        createStars();
        drawScene();
    }

    private void drawScene(){
        drawField();
    }
    private void drawField(){
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < HEIGHT; x++) {
                setCellValueEx(x, y, Color.MIDNIGHTBLUE, "");
            }
        }
        for (Star star:stars)
            star.draw(this);
    }
}
