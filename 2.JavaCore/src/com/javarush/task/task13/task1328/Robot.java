package com.javarush.task.task13.task1328;

/**
 * 3. Класс Robot должен наследоваться от класса AbstractRobot.
 */

public class Robot extends AbstractRobot {

    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
