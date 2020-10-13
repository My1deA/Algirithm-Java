package com.example.demo.leetcode.top.part_4;

public class T75 {

    public void sortColors(int[] nums) {
        int red=0,white=0,blue=0;
        for(int i:nums){
            if(i==0) red++;
            if(i==1) white++;
            if(i==2) blue++;
        }
        int index=0;
        for(int i=0;i<red;i++) nums[index++]=0;
        for(int i=0;i<white;i++) nums[index++]=1;
        for(int i=0;i<blue;i++) nums[index++]=2;
    }
}
