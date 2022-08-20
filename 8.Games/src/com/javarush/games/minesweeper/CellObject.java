package com.javarush.games.minesweeper;

public class CellObject {
    public int x;
    public int y;
    public boolean isMine;
    public boolean isOpen;
    private boolean isFlag;
    public boolean isCursor;
    /**
     * Число меток "Мина" на текущем игровом поле.
     */
    private static int flags_count = 0;
    /**
     * Число соседей - мин.
     */
    public int countMineNeighbors;
    /**
     * Число соседей - отмеченных мин
     */
    public int countFlagsMine;

    public CellObject(int _x, int _y) {
        x = _x;
        y = _y;
        isMine = false;
        isOpen = false;
        isFlag = false;
        isCursor = false;
        countFlagsMine = 0;
        countMineNeighbors = 0;
    }

    public boolean getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(boolean flag) {

        if (flag && !isFlag) flags_count++;
        else if (!flag && isFlag) flags_count--;
        isFlag = flag;
    }

    public static void initFlagsCount() {
        flags_count = 0;
    }

    public static int getFlagsCount() {
        return flags_count;
    }
    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (! (obj instanceof CellObject)) return false;
        CellObject cell = (CellObject) obj;
        return (cell.x == this.x && cell.y == this.y);
    }
}
