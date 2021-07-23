package com.example.demo.pass.structure;



public class KMP {


    public static void main(String[] args) {
        String str="bacbababadababacambabacaddababacasdsd";
        String ptr="ababaca";
        System.out.println(kmp(str.toCharArray(),ptr.toCharArray()));
    }

    //next元素的值则是“最长可匹配前缀子串的下一个位置（从下标0开始 2表示前面两个）” 此时i=3 aba:1  i=4 abab:2
    public static void getNext(int[] next,char[] ptr){
        int i=0,j=-1;
        next[0]=-1;
        while(i<ptr.length-1){
            if(j==-1|| ptr[i] == ptr[j]){
                j++;
                i++;
                if(ptr[i]==ptr[j]){//重复就和前面相同 减少后面 ptr的next[j]的比较 直接比较最前面的值
                    next[i]=next[j];
                }else{
                    next[i]=j;
                }
            }else{
                j=next[j];//取出ptr的第next[j]的值 下一次循环和ptr[i]继续比较
            }
        }

    }

    public static int kmp(char[] str,char[] ptr){
        int i=0,j=0;
        int[] next=new int[ptr.length];
        getNext(next,ptr);
        while(i<str.length && j<ptr.length){
            if(j==-1 || str[i] == ptr[j]){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
        if(j>=ptr.length){
            return i-ptr.length;
        }else{
            return -1;
        }
    }


}
