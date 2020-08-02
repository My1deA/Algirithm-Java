package com.example.demo.algorithm.track;


// 8604 运动员最佳匹配 （回溯） 排列树
/*
问题描述：
        羽毛球队有男女运动员各n人。给定2个n×n 矩阵P和Q。P[i][j]是男运动员i和女运动员 j配对组成混合双打的男运动员竞赛优势；
        Q[i][j]是女运动员i和男运动员j配合的女运动员竞赛优势；由于技术配合和心理状态等各种因素影响,P[i][j]不一定等于Q[j][i]。
        男运动员i和女运动员j配对组成混合双打的男女双方竞赛优势为P[i][j]* Q[j][i]。设计一个算法，计算男女运动员最佳配对法,使各组男女双方竞赛优势的总和达到最大。
        算法设计:设计一个算法，计算男女运动员最佳配对法,使各组男女双方竞赛优势的总和达到最大。

数据输入:第一行有1个正整数n(1≦n≦20〉。接下来的2n行,每行n个数。前n行是p，后n行是q。
        输入文件示例                              输出文件示例
        3                                            52
        10 2 3
        2 3 4
        3 4 5
        2 2 2
        3 5 3
        4 5 1

 算法思想：排列树问题，重新开辟一个数组记录女运动员或者男运动员，对其进行全排列，到回溯到最后一行时将得到的值与之前已得到的最大值进行比较，如果大于之前的最大值，则进行更新*/
public class T_8604 {

    private static Integer max=0;

    public static void backTrace(int p[][],int q[][],int[] index,int k){
        if(k>=p.length){
            int cur=0;
            for(int i=0;i< index.length;i++){
                cur+=p[index[i]][i]*q[i][index[i]];
            }
            if(cur>max){
                max=cur;
            }
        }else{
            for(int i=k;i< index.length;i++){
                swap(index,k,i);
                backTrace(p,q,index,k+1);
                swap(index,k,i);
            }

        }
    }

    public static void swap(int[] index,int i,int j){
        int t=index[i];
        index[i]=index[j];
        index[j]=t;
    }


    public static void main(String[] args) {
        int n=3;
        int[][] p={{10,2,3}, {2,3,4}, {3,4,5}};// 男对女好感
        int[][] q={{2,2,2}, {3,5,3}, {4,5,1}};// 女对男好感
        int[] index=new int[n]; //记录下标
        for(int i=0;i<n;i++)index[i]=i;
        backTrace(p,q,index,0);
        System.out.println(max);
    }
}
