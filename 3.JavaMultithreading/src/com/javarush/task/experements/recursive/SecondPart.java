package com.javarush.task.experements.recursive;

public class SecondPart {
    public static  boolean groupSum(int start, int[] nums, int target) {

        if(start>=nums.length)
            return target==0;
        else if (groupSum(start+1, nums, target)) {
            System.out.print(0);
            return true;
        } else if (groupSum(start+1, nums, target-nums[start])) {
            System.out.print(1);
            return true;
        } else return false;



    }

    public static int count (int start, int[] nums){
        //        if (start>=nums.length) return 0;
        //        if (nums[start+1]!=nums[start]) return 1;
        //        return  1+count ( start+1, nums);
        //return start<nums.length?1+ count(start+1,nums):0;
        if(start>=nums.length) return 0;

        return 1+(start+1<nums.length&&nums[start+1]==nums[start]? count(start+1,nums):0);
    }

    public boolean splitArray(int[] nums) {
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return recArray(nums, index, sum1, sum2);
    }


    private boolean recArray ( int[] nums, int index, int sum1, int sum2 ) {
        if ( index >= nums.length )
            return sum1 == sum2;

        return recArray(nums, index + 1, sum1 + nums[index], sum2) ||
               recArray(nums, index + 1, sum1, sum2 + nums[index]);
    }

    public static  void range(int a,int b){
        if(a==b) return;

        if(a<b) {
            System.out.println(a);
            range(a+1,b);
        } else{
            System.out.println(b);
            range(a,b+1);
        }
    }



    public static void main(String[] args){
        range(2,6);
    }

}
