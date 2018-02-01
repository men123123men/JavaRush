package com.javarush.task.task15.task1522;

public interface Planet {
    static String SUN = "sun";
    static String MOON = "moon";
    static String EARTH = "earth";
    static Planet getInstance(String str){
        switch (str){
            case SUN: return Sun.getInstance();
            case MOON: return  Moon.getInstance();
            case EARTH: return Earth.getInstance();
            default: return null;
        }
    }
}
