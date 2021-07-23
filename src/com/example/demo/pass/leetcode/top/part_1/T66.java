package com.example.demo.pass.leetcode.top.part_1;

public class T66 {

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        int carry=0;
        for(int i=digits.length-1;i>=0;i--){
            int t=carry;
            if(i==digits.length-1){
                if(digits[i]+1>=10){
                    carry=1;
                }
                digits[i]=(digits[i]+1)%10;;
            }else{

                if(digits[i]+carry>=10){
                    carry=1;
                }else{
                    carry=0;
                }
                digits[i]=(digits[i]+t)%10;
            }
        }

        if(carry==1 && digits[0]==0){
            int[] ans=new int[digits.length+1];
            ans[0]=1;
            for(int i=1;i<ans.length;i++){
                ans[i]=digits[i-1];
            }
            return ans;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] a={9,9,9};
        int[] t=plusOne(a);
        for(int i=0;i<t.length;i++){
            System.out.print(t[i]+" ");
        }
    }
}
