package com.javarush.task.task13.task1317;

/* 
The weather is fine

1. Интерфейс Weather должен быть реализован в классе Today.
2. В классе Today должен быть реализован метод getWeatherType, объявленный в интерфейсе Weather.
3. Тип возвращаемого значения метода getWeatherType должен быть String.
4. Метод getWeatherType должен возвращать значение переменной type.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FREEZING));
    }

    static class Today implements Weather{
        private String type;

        public String getWeatherType() {return this.type;}
        Today(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("Today it will be %s", this.getWeatherType());
        }
    }
}
