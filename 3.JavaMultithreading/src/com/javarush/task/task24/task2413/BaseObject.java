package com.javarush.task.task24.task2413;

/*
1. В классе BaseObject должно быть создано приватное поле x типа double.
2. В классе BaseObject должно быть создано приватное поле y типа double.
3. В классе BaseObject должно быть создано приватное поле radius типа double.
4. В классе BaseObject должен быть создан корректно работающий конструктор с
   тремя параметрами типа double (x, y, radius)
 */
public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public abstract void draw(Canvas can);

    public abstract void move();

    public boolean intersects(BaseObject o) {
        if (o == null) return false;
        return Math.hypot(this.x - o.x, this.y - o.y) <= Math.max(this.radius, o.radius);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
