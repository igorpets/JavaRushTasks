package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;

/**
 * Звезда.
 */
public class Star extends GameObject {
    private static final String STAR_SIGN = "\u2605";
    public Star(double _x, double _y){
        super(_x, _y);
    }
    public void draw(Game game){
        game.setCellValueEx((int) x, (int)y, Color.NONE, STAR_SIGN, Color.WHITE, 100);
    }
}
