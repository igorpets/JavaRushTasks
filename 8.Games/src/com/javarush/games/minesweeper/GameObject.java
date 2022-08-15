package com.javarush.games.minesweeper;

public class GameObject {
    public int x;
    public int y;
    public boolean isMine;
    public GameObject(int _x, int _y, boolean _isMine) {
        x = _x;
        y = _y;
        isMine = _isMine;
    }
}
