package com.javarush.task.task24.task2413;

/*
1. Приватное поле speed типа double должно быть создано в классе Ball.
2. Приватное поле direction типа double должно быть создано в классе Ball.
3. Приватное поле dx типа double должно быть создано в классе Ball.
4. Приватное поле dy типа double должно быть создано в классе Ball.
5. Приватное поле isFrozen типа boolean должно быть создано в классе Ball.
6. В классе Ball должен быть создан публичный конструктор (поведение и параметры описаны в условии).
7. В классе Ball должен существовать корректный публичный геттер для поля speed.
8. В классе Ball должен существовать корректный публичный геттер для поля direction.
9. В классе Ball должен существовать корректный публичный геттер для поля dx.
10. В классе Ball должен существовать корректный публичный геттер для поля dy.

1. Метод move() в классе Ball должен увеличивать значение x на dx, если значение поля isFrozen равно false.
2. Метод move() в классе Ball должен увеличивать значение y на dy, если значение поля isFrozen равно false.
3. Метод move() в классе Ball не должен менять значения полей x и y, если значение поля isFrozen равно true.
4. В классе Ball должен быть реализован метод draw(Canvas canvas) в соответствии с условием задачи.
5. В классе Ball должен быть реализован метод start() устанавливающий значение поля isFrozen в false.
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
