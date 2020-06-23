package com.example.demo.leetcode.offer.more;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.CheckedOutputStream;

/* 剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

输入：target = 9
输出：[[2,3,4],[4,5]]
 */
class Solution57_2 {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list=new ArrayList<>();
        int i=1;
        int j=1;
        int sum=0;
        while(i<=(target/2)){
            if(sum<target){
                sum+=j;
                j++;
            }else if(sum>target){
                sum-=i;
                i++;
            }else{
                int[] t=new int[j-i];
                for(int k=0;k<j-i;k++){
                    t[k]=k+i;
                }
                list.add(t);
                //更新
                sum-=i;
                i++;
            }
        }

        int[][] ans=new int[list.size()][];
        for(int k=0;k<list.size();k++){
            ans[k]=list.get(k);
        }

        return ans;
    }
}

public class Title57_2 {
    public static void main(String[] args) {
        Solution57_2 solution57_2=new Solution57_2();
        int[][] ans=solution57_2.findContinuousSequence(9);
        for(int i=0;i<ans.length;i++){
            for (int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
