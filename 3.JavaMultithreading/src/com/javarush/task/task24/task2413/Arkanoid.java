package com.javarush.task.task24.task2413;

public class Arkanoid {
    private int width;
    private int height;
    public static void main(String[] args) {

    }
    public Arkanoid(int w, int h){
        width = w;
        height = h;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
}
