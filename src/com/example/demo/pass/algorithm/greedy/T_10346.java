package com.example.demo.pass.algorithm.greedy;


// 10346 带价值作业安排问题  贪心 hash
/*Description
        已知n项作业E={1, 2, … ,n} 需要完成，只有一台机器，同一时刻至多完成一个作业，而且每项作业需要的时间都是单位时间1。第k项作业要求在时间fk时刻执行并完成，而且
        完成这项作业将获得效益pk，（k=1, 2, … , n）。E的子集称为相容的，如果它们可以被安排由一台机器完成。

        带限期和价值的作业安排问题就是：要在所给的作业集合中选出总效益值最大的相容子集，请输出最大的总效益值。
 输入格式
        输入3行：
        第一行，一个数n，表示n个作业（n<10000）。
        第二行，n个正数，表示这n个作业的应执行的时间点。
        第三行，n个正数，表示这n个作业的效益值。
 输出格式
        输出：相容作业子集所获得的最大总效益。

        例如：7个作业
        时间点和效益值分别是：
        1  8   8  5 9  3  5
        20 25 30 7 18 10 18
        则：可以获得的最大总效益为：20 + 30 +18 + 10 + 18 = 96

        输入样例                        输出样例
        7                              96
        1 8 8 5 9 3 5
        20 25 30 7 18 10 18
提示
        贪心法
        1）按价值从高到低排序所有作业；
        2）纳入作业1；
        3）从作业2到作业n，逐个检测是否和已经纳入的作业相容，相容则添入“相容作业集合”中。
        此处，相容的判断不同于书上的活动安排问题，因为每个作业仅需一个单位时间就可完成，所以每当判断一个新的作业是否可以加入进已有的相容作业集合，就看这个新的作业是否
        能在其执行时间内被安排。*/

// 其实可以用hash来做
public class T_10346 {

    public static int hashset(int[] e,int[] fk){
        int[] exist=new int[e.length];
        sort(e,fk);
        int sum=0;
        for(int i=0;i<e.length;i++){
            if(!isExist(exist,e[i])){
                //System.out.print(fk[i]+" ");
                sum+=fk[i];
            }
        }
        return sum;
    }

    public static boolean isExist(int[] exist,int n){

        for(int i=0;i< exist.length;i++){
            if(exist[i]==n){
                return true;
            }else if(exist[i]==0) {
                exist[i]=n;
                return false;
            }
        }
        return false;
    }


    //先拍下
    public static void sort(int[] e , int[] fk){
        for(int i=0;i<fk.length;i++){
            for(int j=0;j<fk.length-1;j++){
                if(fk[j]<fk[j+1]){
                    swap(e,fk,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] e,int[] fk, int i,int j){
        int t=e[i];
        e[i]=e[j];
        e[j]=t;

        t=fk[i];
        fk[i]=fk[j];
        fk[j]=t;
    }


    public static void main(String[] args) {
        int[] e={1,8,8,5,9,3,5};
        int[] fk={20,25,30,7,18,10,18};
        System.out.println(hashset(e,fk));
    }
}








