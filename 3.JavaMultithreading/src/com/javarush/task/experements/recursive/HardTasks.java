package com.javarush.task.experements.recursive;

import java.util.Scanner;

public class HardTasks {

    public static  boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);

        if (groupSum(start + 1, nums, target - nums[start])) return true;

        if (groupSum(start + 1, nums, target)) return true;

        return false;
    }


    public static long power(long number, int power){
        if(power==1) return number;
        long currentPart = power(number,power/2);
        return currentPart*currentPart*(power%2==0?1:number);
    }
    public static long power2(long number, int power){
        if(power==1) return number;
        return power2(number,power/2)*power2(number,power/2)*(power%2==0?1:number);
    }

    public static int nod(int a, int b){
        if(b==0) return a;
        else
            return nod(b,a%b);
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void printer(){
        String currentStr = scanner.nextLine();
        if(!currentStr.equals("exit"))
            printer();
        System.out.println(currentStr);
    }



    public static void main(String[] args) throws InterruptedException {
        //groupSum(0, new int[]{4,5,6,7,8}, 12);


        printer();

        Thread.sleep(100);

        long start2 = System.nanoTime();
        System.out.println(power2(3,39));

        System.out.println((System.nanoTime()-start2)/1_000);

        long start = System.nanoTime();
        System.out.println(power(3,39));
        System.out.println(Long.MAX_VALUE);

        System.out.println((System.nanoTime()-start)/1_000);
    }
}
