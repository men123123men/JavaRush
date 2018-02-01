package com.javarush.task.task25.task2502;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            if(loadWheelNamesFromDB().length!=4)
                throw new IllegalArgumentException("Слишком мало колес!");
            wheels = Arrays.stream(loadWheelNamesFromDB())
                    .map(Wheel::valueOf)
                    .collect(Collectors.toList());
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
