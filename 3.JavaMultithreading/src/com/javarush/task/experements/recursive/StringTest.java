package com.javarush.task.experements.recursive;

import java.util.List;
import java.util.stream.Collectors;

public class StringTest {
    public static int countHi(String str) {
        if(str.length()<2) return 0;
//        if(str.substring(0,2).equals("hi")) return 1+countHi(str.substring(2));
//        return countHi(str.substring(1));
        return (str.substring(0,2).equals("hi")?1:0)+countHi(str.substring(1));
    }
    public static String changeXY(String str) {
        if (str.length()==0) return "";
        String start = str.substring(0,1);
        start = start.equals("x")?"y":start;
        return start.concat(changeXY(str.substring(1)));
    }
    public static String changePi(String str) {
        if(str.length()<2) return "";
        String end = str.substring(str.length()-2);
        if(end.equals("pi")) return "3.14".concat(changePi(str.substring(2)));
        return str.substring(0,1).concat(changePi(str.substring(1)));
    }
    public List<Integer> noZ(List<Integer> strings) {
        return strings.stream()
                .map(i->i*2)
                .filter(i->i%10!=2)
                .collect(Collectors.toList());
    }
    public List<Integer> noNeg(List<Integer> nums) {
        return nums.stream().filter(i->!(i<0)).collect(Collectors.toList());
    }
    public List<Integer> noTeen(List<Integer> nums) {
        nums.removeIf(i->i>12&&i<20);
        return nums;
    }
    public int diff21(int n) {
        return n<21? 21-n: 2*(n-21);
    }
    public boolean parrotTrouble(boolean talking, int hour) {
        return !(!talking||hour>6&&hour<21);
    }
    public boolean posNeg(int a, int b, boolean negative) {
        return  (negative? a<0&&b<0 : a*b<0);
    }
    public String noX(String str) {
        if(str.length()==0) return "";
        String start = str.substring(0,1);
        return (start.equals("x")?"":start).concat(noX(str.substring(1)));
    }
    public boolean array6(int[] nums, int index) {
        if (index>nums.length-1) return false;
        return nums[index]==6? true: array6(nums,index+1);
    }
    public int array11(int[] nums, int index) {
//        if(index==nums.length) return 0;
//        return (nums[index]==11?1:0) + array11(nums,index+1);

        int result=0;
        while (index< nums.length){
            result = (nums[index]==11?1:0) + result;
            index= index+1;
        }
        return result;


    }


    public static void main(String[] args) {
        System.out.println(countHi("xhixhix"));
        //System.out.println("xhixhi".substring("xhixhi".length()-2));
        System.out.println(changePi("xpixpipippppppipppppiiii"));
    }
}
