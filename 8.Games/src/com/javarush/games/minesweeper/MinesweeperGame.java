package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    /**
     * Текст "💣" для отображения Мины на игровом поле.
     */
    private static final String MINE = "\uD83D\uDCA3";
    /**
     * Текст "🚩" для отображения Флага на игровом поле.
     */
    private static final String FLAG = "\uD83D\uDEA9";

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ANTIQUEWHITE);
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        gameObject.countMineNeighbors = 0;
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                GameObject res = gameField[y][x];
                result.add(res);
                if (res.isMine) gameObject.countMineNeighbors++;
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                GameObject obj = gameField[y][x];
                if (!obj.isMine)
                    getNeighbors(obj);
            }
        }
    }

    private void openTile(int x, int y) {
        GameObject obj = gameField[y][x];
        if (obj.isMine)
            setCellValue(x, y, MINE);
        else
            setCellNumber(x, y, obj.countMineNeighbors);
        setCellColor(x, y, Color.LIGHTBLUE);
        obj.isOpen = true;
    }

    private void countMines(GameObject cobj) {
        cobj.countMineNeighbors = 0;
        for (int y = cobj.y - 1; y <= cobj.y + 1; y++) {
            for (int x = cobj.x - 1; x < cobj.x + 1; x++) {
                if (gameField[y][x].isMine) cobj.countMineNeighbors++;
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }
}