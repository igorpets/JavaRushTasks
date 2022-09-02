package com.javarush.games.minigames.mini07;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Работа с мышью
*/

public class PaintGame extends Game {

    @Override
    public void initialize() {
        //напишите тут ваш код
        setScreenSize(5,5);
        for (int i=0;i<5;i++)
            for(int k=0;k<5;k++)
                setCellColor(i,k,Color.WHITE);
    }

    //напишите тут ваш код
    public void onMouseLeftClick(int x, int y) {
        setCellColor(x, y, Color.GREEN);
    }
    public void onMouseRightClick(int x, int y) {
        setCellColor(x, y, Color.ORANGE);
    }
}
