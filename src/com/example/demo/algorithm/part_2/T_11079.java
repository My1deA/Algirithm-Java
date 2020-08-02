package com.example.demo.algorithm.part_2;

import java.util.Arrays;

// 11079 不能移动的石子合并  贪心
/*Description
        有n堆石子形成一行(a1,a2,…,an，ai为第i堆石子个数)，现要将石子合并成一堆，规定每次可选择至少2堆最多k堆移出然后合并，每次合并的分值为新堆的石子数。
        若干次合并后，石子最后肯定被合并为一堆，得分为每次合并的分值之和。
        现在求解将这n堆石子合并成一堆的最低得分和最高得分。

        输入格式    两行。第一行n和k，第二行a1 a2 … an，每个ai(1<=i<=n)表示第i堆石子的个数，n<=100，2<=k<=n。

        输出格式    仅一行，为石子合并的最低得分和最高得分，中间空格相连。

        输入样例                                    输出样例
        7 3                                         199 593
        45 13 12 16 9 5 22

        提示
        此题贪心算法求解.给这题标记标签"dp"方法是同学所为,并非老师标注.动规不是不可以,但有更好更快的贪心解法的.

        如7堆石头，每次可选择最少2堆最多3堆合并，可以如下这样合并：
        第1次合并：45+22=67
        第2次合并：67+16=83
        第3次合并：83+13=96
        第4次合并：96+12=108
        第5次合并：108+9=117
        第6次合并：117+5=122
        合并的总分值：67+83+96+108+117+122=593，593已是最大分值。

        也可以这样合并：
        第1次合并：5+9+12=26
        第2次合并：13+16+22=51
        第3次合并：45+51+26=122
        合并的总分值：26+51+122=199，199已是最小分值。

        因此此题贪心的方法如下：
        （1）保证每次选两堆最多的，合并直至只剩一堆为止，能获得最大得分；这个和huffman树构造是相同的，不再详述！

        （2）保证每次选k堆最少的，合并直至只剩一堆为止，能获得最小得分。
        这个是多元huffman树的构造。要注意的是：在合并之前，若n%(k-1)!=1，说明合并到最后一轮时，剩下不是k堆（而是比k堆少），这样算的并不是最小得分，
        而必须在合并之前添加若干个为0的虚拟堆，目的为凑成的堆数保证每次都能有k堆合并（包括最后一次）最后合并为1堆。
        因此，在合并前作如下处理：

        //假设石头每堆个数放于stone[1]~stone[n],且stone[n]之后最多k-1个数组单元为可写;
        while (n % (k - 1) != 1)
        {
            n++;
            stone[n]=0;
        }

      */
public class T_11079 {
    // 2个最大值相加 所获取的值最大
    public static int max(int[] a,int n,int k){
        //排序 逆序
        sort(a,1);
        System.out.println(Arrays.toString(a));

        int i=0;
        int t=0;
        int sum=0;
        while(i<n){
            if(i==0){
                t=a[i]+a[i+1];
                i++;
            }else{
                t=t+a[i];
            }
            sum+=t;
            i++;
        }
        return sum;
    }

    public static int min(int[] a,int n,int k){
        while(n%(k-1)!=1){
            n++;
        }
        int[] b=new int[n];
        for(int i=0;i<a.length;i++){
            b[i]=a[i];
        }

        int i=0,t=0,sum=0;
        while(i<n-1){
            //每次需要排序 小的在前
            sort(b,0);
            //初始化 t
            t=0;
            for(int j=0;j<k;j++){
                t+=b[i+j];
                b[i+j]=0;
            }
            // 将b[0]设置为 t 重新进行排序
            b[0]=t;
            i=i+k-1;
            sum+=t;
        }
        return sum;
    }

    public static void clear(int[] a,int t,int n){
        for(int i=0;i<n;i++){
            a[i]=0;
        }
        a[n]=t;
    }

    public static void sort(int[] a,int size){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]<a[j+1] && size==1){
                    swap(a,j,j+1);
                }else if(a[j]>a[j+1] && size==0){
                    swap(a,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static void main(String[] args) {
        int n=7;
        int k=3;
        int[] a={45,13,12,16,9,5,22};
        System.out.println(max(Arrays.copyOf(a,a.length),n,3));
        System.out.println(min(Arrays.copyOf(a,a.length),n,3));
    }
}
