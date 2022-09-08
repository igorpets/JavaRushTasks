package com.javarush.task.task14.task1413;

public class Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer(Keyboard key, Mouse mo, Monitor mon) {
        keyboard = key;
        mouse = mo;
        monitor = mon;
    }
    public Keyboard getKeyboard(){
        return keyboard;
    }
    public Mouse getMouse(){
        return mouse;
    }
    public Monitor getMonitor(){
        return monitor;
    }
}
