package com.javarush.task.task03.task0315;

/* 
Каждый охотник желает знать…
*/

public class Solution {
    public static void main(String[] args) {
//        1st — first
//        2nd — second
//        3rd — third
//        4th — fourth
//        5th — fifth
//        6th — sixth
//        7th — seventh
//        8th — eighth
//        9th — ninth
//        10th — tenth
        Red firstColor = new Red();
        Orange secondColor = new Orange();
        Yellow thirdColor = new Yellow();
        Green fourthColor = new Green();
        Blue fifthColor = new Blue();
        Indigo sixthColor = new Indigo();
        Violet seventhColorv = new Violet();
    }

    public static class Red {
        public Red() {
            System.out.println("Red");
        }
    }

    public static class Orange {
        public Orange() {
            System.out.println("Orange");
        }
    }

    public static class Yellow {
        public Yellow() {
            System.out.println("Yellow");
        }
    }

    public static class Green {
        public Green() {
            System.out.println("Green");
        }
    }

    public static class Blue {
        public Blue() {
            System.out.println("Blue");
        }
    }

    public static class Indigo {
        public Indigo() {
            System.out.println("Indigo");
        }
    }

    public static class Violet {
        public Violet() {
            System.out.println("Violet");
        }
    }
}
