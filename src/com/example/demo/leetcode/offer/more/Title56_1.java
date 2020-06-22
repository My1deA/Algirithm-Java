package com.example.demo.leetcode.offer.more;


import java.util.*;

/* 剑指 Offer 56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
 
限制：2 <= nums.length <= 10000
 */
class Solution56_1 {
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
                continue;
            }
            map.put(nums[i],nums[i]);
        }
        int[] ans=new int[map.size()];
        int i=0;
        Iterator<Map.Entry<Integer, Integer>> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> tMap=iterator.next();
            ans[i++]=tMap.getValue();
        }
        return ans;
    }

    //a^a=0
    //a^0=a
    //a^b^c=a^c^b
    //a&(-a)=最低位为1的二进制（从又到左）
    //所有的异或结果得到sum=2^10=8
    //flag=-8&8=8
    //可分为两组，一组为与flag相与等于1的[10]，另一组为0的[1,2,4,1,4,3,3]
    //组内异或分别得到【10】【2】
    public int[] singleNumbers2(int[] nums) {
        int sum=0;
        //得到异或结果，即为不相同两个数的异或结果sum
        for(int num:nums)
            sum^=num;
        //得到sum的二进制的1的最低位
        // 0000 0100 1110 & 1111 1011 0010 = 0000 0000 0010
        int flag=(-sum)&sum;
        int result[]=new int[2];
        //分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for(int num:nums){
            if((flag&num)==0)
                result[0]^=num;
            else{
                result[1]^=num;
            }
        }
        return result;
    }
}

public class Title56_1 {
    public static void main(String[] args) {
        int [] nums = {1,2,10,4,1,4,3,3};
        Solution56_1 solution56_1=new Solution56_1();
        System.out.println(Arrays.toString(solution56_1.singleNumbers(nums)));
    }
}
