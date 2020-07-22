package com.example.demo.leetcode.top.part_1;


public class Solution13 {
    public int romanToInt(String s) {
        if(s.length()==0)return 0;
        int sum=getNum(s.charAt(0)),pre,cur;
        for(int i=1;i<s.length();i++){
            pre=getNum(s.charAt(i-1));
            cur=getNum(s.charAt(i));
            if(pre>=cur){
                sum+=cur;
            }else{
                sum+=cur-2*pre;
            }
        }

        return sum;
    }

    public int getNum(char ch){
        if( ch == 'I'){
            return 1;
        }else if(ch == 'V'){
            return 5;
        }else if(ch == 'X'){
            return 10;
        }else if(ch == 'L'){
            return 50;
        }else if(ch == 'C'){
            return 100;
        }else if(ch == 'D'){
            return 500;
        }else if(ch == 'M'){
            return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution13 solution13=new Solution13();
        System.out.println(solution13.romanToInt("IX"));
    }
}
