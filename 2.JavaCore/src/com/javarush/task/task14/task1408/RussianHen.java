package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 5;
    }
    @Override
    String getDescription() {
        return "Я - курица. Моя страна - Russia. Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
