package com.javarush.games.minesweeper;

public class CellObject {
    public int x;
    public int y;
    public boolean isMine;
    public boolean isOpen;
    public boolean isFlag;
    public int countMineNeighbors;
    public CellObject(int _x, int _y, boolean _isMine) {
        x = _x;
        y = _y;
        isMine = _isMine;
        isOpen = false;
        isFlag = false;
        countMineNeighbors = 0;
    }
}
