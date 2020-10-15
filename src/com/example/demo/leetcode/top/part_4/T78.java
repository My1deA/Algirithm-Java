package com.example.demo.leetcode.top.part_4;

import java.util.ArrayList;
import java.util.List;

public class T78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        dfs(ans,temp,nums,0);
        return ans;
    }


    public static void dfs(List<List<Integer>> ans,ArrayList<Integer> temp,int[] num,int k){
        // 直接 ans.add（temp） 只会存放temp的指针 temp 改变就全改变
       if(k>=num.length){
           ans.add(new ArrayList<>(temp));
       }else{
           temp.add(num[k]);
           dfs(ans,temp,num,k+1);
           temp.remove(temp.size()-1);
           dfs(ans,temp,num,k+1);
       }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> ans=subsets(nums);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }


}
