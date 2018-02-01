package com.javarush.task.task09.task0924;

import java.util.ArrayList;

/* 
Страшная сказка
*/

public class Solution {
    public static LittleRedRidingHood hood = new LittleRedRidingHood();
    public static Grandmother grandmother = new Grandmother();
    public static Patty patty = new Patty();
    public static Woodman woodman = new Woodman();
    public static Wolf wolf = new Wolf();

    public static void main(String[] args) {
        wolf.ate.add(grandmother);
        wolf.ate.add(hood);
        woodman.killed.add(wolf);
    }

    //красная шапочка
    public static class LittleRedRidingHood extends StoryItem {
        ArrayList killed = new ArrayList();
        ArrayList ate = new ArrayList();
    }

    //бабушка
    public static class Grandmother extends StoryItem {
        ArrayList killed = new ArrayList();
        ArrayList ate = new ArrayList();
    }

    //пирожек
    public static class Patty extends StoryItem {
        ArrayList killed = new ArrayList();
        ArrayList ate = new ArrayList();
    }

    //дровосек
    public static class Woodman extends StoryItem {
        ArrayList killed = new ArrayList();
        ArrayList ate = new ArrayList();
    }

    //волк
    public static class Wolf extends StoryItem {
        ArrayList killed = new ArrayList();
        ArrayList ate = new ArrayList();
    }

    public static abstract class StoryItem {
        public ArrayList<StoryItem> killed = new ArrayList<StoryItem>();
        public ArrayList<StoryItem> ate = new ArrayList<StoryItem>();
    }
}
