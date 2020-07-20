package com.example.demo.leetcode.top.part_1;

public class Solution8 {
    public int myAtoi(String str) {
        int sign=1;//默认为正
        int cur=0;
        char[] chars=str.trim().toCharArray();

        if(chars.length == 0 ){
            return 0;
        }else if(chars[cur]<'0' || chars[cur] >'9'){
            if(chars[cur]=='-'){
                sign=-sign;
                cur++;
            }else if(chars[cur]=='+'){
                cur++;
            }else{
                return 0;
            }
        }
        //System.out.println(chars[cur]);

        long sum=0;
        for(int i=cur;i<chars.length;i++){

            if(chars[i]<'0' || chars[i] >'9'){
                break;
            }
            if(sign==-1){
                sum=sum*10-(chars[i]-'0');
                if(sum<Integer.MIN_VALUE){
                    sum=Integer.MIN_VALUE;
                    break;
                }
            }else{
                sum=sum*10+(chars[i]-'0');
                if(sum>Integer.MAX_VALUE){
                    sum=Integer.MAX_VALUE;
                    break;
                }
            }

        }


        return (int)sum;
    }

    public static void main(String[] args) {
        Solution8 solution8 =new Solution8();
        System.out.println(solution8.myAtoi("4193 with words"));
    }
}
