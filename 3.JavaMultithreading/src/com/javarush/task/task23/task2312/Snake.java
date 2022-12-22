package com.javarush.task.task23.task2312;

import java.util.List;

/*
1. В классе Snake должно быть объявлено поле sections типа List<SnakeSection>.
2. В классе Snake должно быть объявлено поле isAlive типа boolean.
3. В классе Snake должно быть объявлено поле direction типа SnakeDirection.
4. В классе Snake должен быть создан корректный геттер для поля sections.
5. В классе Snake должен быть создан корректный геттер для поля isAlive.
6. В классе Snake должен быть создан корректный геттер для поля direction.
7. В классе Snake должен быть создан корректный сеттер для поля direction.
8. Все поля класса Snake должны быть объявлены с модификатором доступа private.
9. Все методы класса Snake должны быть объявлены с модификатором доступа public.
* */
public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;
    public List<SnakeSection> getSections(){
        return sections;
    }
    public boolean getIsAlive(){
        return isAlive;
    }
    public SnakeDirection getDirection(){
        return direction;
    }
    public void setDirection(SnakeDirection direction){
        this.direction = direction;
    }
}
