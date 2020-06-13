package com.example.demo.leetcode.offer.math;

/* 面试题43. 1～n整数中1出现的次数
输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

输入：n = 12
输出：5
示例 2：

输入：n = 13
输出：6
 
限制：1 <= n < 2^31
 */
public class Tilte43 {
    public static void main(String[] args) {
        Solution43 solution43=new Solution43();
        System.out.println(solution43.countDigitOne(1000));
    }
}

class Solution43 {

    public int countDigitOne(int n) {
        int res=0,bit=1;//个位
        int high=n/10,cur=n%10,low=0;
        while(high != 0 || cur != 0){
            //统计的是 bit(目前位) 出现的 1 总数 即使前面的高位有1也不统计
            if(cur==0){
                //2310 有231种 bit为1的情况
                res+=high*bit;
            }else if( cur == 1){
                // 2310 cur:1 low=0 1的总数 10(1) | 2314 cur:1 low=0 1的总数 10 11 12 13 14（5,11的1 之前已经统计）
                res+=high*bit+low+1;
            }else{// > 1
                //2324 bit:10 加上10-19
                res+=high*bit+bit;
            }

            low=cur*bit+low;
            cur=high%10;
            high=high/10;
            bit=10*bit;
        }
        return res;
    }
    /*public int countDigitOne(int n) {
        int res=0,bit=1;//个位
        int high=n/10,cur=n%10,low=0;//high ：减去基础位(个位的)位 cur: 目前位 low: 次低位
        while(high!=0 || cur != 0){
            if(cur == 0 ){
                res+=high*bit;
            }else if(cur == 1){
                res+=high*bit+low+1;// 2413 241--3 (10 11 12 13) low+1
            }else{//>1
                res+=high*bit+bit;// 默认十位出现10-19
            }
            low=cur*bit+low;
            cur=high%10;
            high=high/10;
            bit=10*bit;
        }
        return  res;
    }*/
}
