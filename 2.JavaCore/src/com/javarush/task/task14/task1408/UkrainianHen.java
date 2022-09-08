package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 15;
    }
    @Override
    String getDescription() {
        return "Я - курица. Моя страна - " + Country.UKRAINE + ". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
