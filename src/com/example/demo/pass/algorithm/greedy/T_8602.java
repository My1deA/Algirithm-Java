package com.example.demo.pass.algorithm.greedy;



// 8602 区间相交问题 贪心
/*Description
        给定x轴上n个闭区间，去掉尽可能少的闭区间，使剩下的闭区间都不相交。
        注意：这里，若区间与另一区间之间仅有端点是相同的，不算做区间相交。例如，[1，2]和[2，3]算是不相交区间。
        这个问题基本等同于书本的活动安排问题。

        输入格式
        第一行一个正整数n(n<=50)，表示闭区间数。接下来n行中，每行2个整数，表示闭区间的2个整数端点。

        输出格式
        输出去掉的最少的闭区间数。

        输入样例     输出样例
        3             2
        10 20
        10 15
        12 15*/

public class T_8602 {

    public static int getallActivity(int[] s,int[] f,int[] rc){
        sort(s,f);
        //用于记录
        //默认第一个可以成功加入
        int j=0;
        rc[0]=1;
        int count=1;
        for(int i=1;i<f.length;i++){
            //如果 j 结束时间在 下一个活动开始前 就可以更新
            if(f[j]<=s[i]){
                j=i;
                rc[j]=1;
                count++;
            }else{
                rc[j]=0;
            }
        }
        return s.length-count;
    }


    public static void sort(int[] s,int[] f){
        for(int i=0;i<f.length;i++){
            for(int j=0;j<f.length-1;j++){
                if(f[j]>f[j+1]){
                    swap(s,f,i,j);
                }
            }
        }
    }

    // s f 都要交换
    public static void swap(int[] s,int[] f,int i,int j){
        int t=s[i];
        s[i]=s[j];
        s[j]=t;

        t=f[i];
        f[i]=f[j];
        f[j]=t;

    }


    public static void main(String[] args) {
        //活动数
        int n=3;
        //活动开始时间
        int[] s={10,10,12};
        //活动结束时间
        int[] f={20,15,15};
        //用于记录 哪个活动被选中
        int[] rc=new int[n];

        System.out.println(getallActivity(s,f,rc));
    }
}
