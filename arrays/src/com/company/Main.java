package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] nums;
        nums = new int[5][3];
        nums[1][1] = 9;
        nums[2][2] = 6;
        for (int[] value1:nums){
            for (int value2:value1){
                System.out.println(value2);
            }
        }
    }
}
