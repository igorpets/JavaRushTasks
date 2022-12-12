package com.javarush.task.task24.task2413;

/*
1. В классе Ball должен быть создан метод void setDirection() c одним параметром типа double
    (реализацию смотри в условии).
2. В классе Ball должен быть создан метод void checkRebound c четырьмя параметрами типа int.
 */
public class Ball extends BaseObject {
    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    public Ball(double x, double y, double radius) {
        super(x, y, radius);
        isFrozen = true;
    }

    public void setDirection(double direction){
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }
    void checkRebound(int minx, int maxx, int miny, int maxy) {

    }
    public void start() {
        isFrozen = false;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        isFrozen = true;
    }

    @Override
    public void draw(Canvas can) {
        can.setPoint(x, y, 'O');
    }

    @Override
    public void move() {
        if (!isFrozen) {
            x += dx;
            y += dy;
        }
    }
}
