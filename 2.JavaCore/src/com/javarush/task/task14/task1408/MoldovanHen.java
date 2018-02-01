package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() { return 2; }
    @Override
    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц."
                ,super.getDescription(), Country.MOLDOVA , getCountOfEggsPerMonth());
    }
}
