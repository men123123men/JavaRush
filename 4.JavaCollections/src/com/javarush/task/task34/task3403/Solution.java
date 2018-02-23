package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
//    public static void main(String[] args){
//        Solution solution = new Solution();
//        solution.recursion(132);
//    }


    public void recursion(int n) {
        if (n==1) return;
        int i = 2;
        while (n%i!=0)
           i++;
        System.out.print(i+" ");
        recursion(n/i);
    }
}
