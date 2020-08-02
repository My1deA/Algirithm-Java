package com.example.demo.algorithm.greedy;


// 17103 基建建设 贪心
// 解题思路： 圆半径为4km 覆盖范围是8km 给出一定点 求出最少信号基站个数
// 先将地点排序 然后以 第一个地点为基准 将基站放置到离他4km地方 则基站覆盖范围是8km 当有其他地点大于8km时  再重新在此地点离他4km地方重新设置基站
public class T_17103 {

    public static void sort(int[] a){

    }

    public static int build(int[] a){
        sort(a);//从小到大
        int count=0;
        int km=0;
        for(int i=0;i<a.length;i++){
            if(i==0){
                km=a[i]+8;
                count++;
            }else if(a[i]>km){
                km=a[i]+8;
                count++;
            }
        }
        return count;
    }

}
