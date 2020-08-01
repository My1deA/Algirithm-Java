package com.example.demo.algorithm.part_1;

// 8603 子集和问题 回溯
/*Description
        S是一个整数集合，S={x1,x2,...,xn}，c是一个整数。这里集合元素xi（1<=i<=n）和c都是整数，可能为负。子集和问题就是：判断是否存在S的一个子集S1，使得：
        对S集合子集树采用深度优先的顺序进行搜索，子集树从上到下每层标示着S集合中每个从左到右元素“选”或者“不选”（左1右0）。试着用回溯算法设计解子集和问题。

                                    A
                              1/        \0
                            B             C
                        1/  \0         1/   \0
                        D   E           F    G
                      1/\0 1/\0       1/\0  1/\0
                      H I   J K       L M   N O


输入格式
        第一行2个数：正整数n和整数c。n表示S集合的大小（n<=100），c是子集和的目标值。接下来一行中，有n个整数，表示集合S中的元素。

输出格式
        将子集和问题的解输出，当无解时，输出"No Solution"（注意No Solution的大小写，空格，无标点）。
        注意：依据S集合元素从左到右依次来画子集树，因此子集树唯一。
        若存在多种子集和问题的解时，只输出在这个唯一的子集树按深度优先方向遇到的第一个解，这样保证解的唯一性，利于评判。
        如：5 10                                          如：5 10                             又如：5 -30
        2 2 6 3 3                                          2 2 3 3 6                            2 -2 6 -30 -3
        这里，2+2+6=10，2+2+3+3=10，但只输出2 2 6            只输出2 2 3 3                          只输出2 -2 -30

        输入样例                    输出样例
        5 10                       2 2 6
        2 2 6 5 4
*/

public class T_8603 {

    private static Integer sum;
    private static Integer flag=0;

    public static void backTrace(int[] a,int[] b,int[] rc,int k,int cur){
        if(k>=a.length){
            //System.out.println(cur);
            if(sum==cur && flag==0){
                for(int i=0;i<rc.length;i++){
                    if(b[i]==1){
                        rc[i]=1;
                        System.out.print(a[i]+" ");
                    }
                }
                System.out.println("");
                flag=1;
            }
        }else{
                b[k]=1;
                cur+=a[k];
                backTrace(a,b,rc,k+1,cur);
                cur-=a[k];
                b[k]=0;
                backTrace(a,b,rc,k+1,cur);
        }
    }

    public static void main(String[] args) {
        int n=5;
        sum=10;
        int[] a={2,2,6,5,4};
        int[] b=new int[n];
        int[] rc=new int[n];

        backTrace(a,b,rc,0,0);
        for(int i=0;i<rc.length;i++){
            if(rc[i]==1){
                System.out.print(a[i]+" ");
            }
        }
    }


}
