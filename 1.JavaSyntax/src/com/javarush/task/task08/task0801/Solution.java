package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {


        HashSet<String> plantFood = new HashSet();
        plantFood.add("арбуз");
        plantFood.add("банан");
        plantFood.add("арбуз");
        plantFood.add("вишня");
        plantFood.add("груша");
        plantFood.add("дыня");
        plantFood.add("ежевика");
        plantFood.add("жень-шень");
        plantFood.add("земляника");
        plantFood.add("ирис");
        plantFood.add("картофель");

        Iterator iteratorSet = plantFood.iterator();

        while(iteratorSet.hasNext())
            System.out.println(iteratorSet.next());

    }
}
