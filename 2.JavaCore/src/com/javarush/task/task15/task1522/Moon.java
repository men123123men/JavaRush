package com.javarush.task.task15.task1522;

public class Moon implements Planet{
    private Moon(){}
    private static volatile Moon instance;
    public static Moon getInstance(){
        if (instance==null){
            synchronized(Moon.class){
                if(instance == null)
                    instance = new Moon();
            }
        }
        return instance;
    }


}
