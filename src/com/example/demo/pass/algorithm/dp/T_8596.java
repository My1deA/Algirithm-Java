package com.example.demo.pass.algorithm.dp;

//8596 最长上升子序列（优先做） dp
/*Description
        A numeric sequence of ai is ordered if a1 < a2 < ... < aN.
        Let the subsequence of the given numeric sequence (a1, a2, ..., aN) be any sequence (ai1, ai2, ..., aiK),
        where 1 <= i1 < i2 < ... < iK <= N.
        For example, sequence (1, 7, 3, 5, 9, 4, 8) has ordered subsequences, e. g., (1, 7), (3, 4, 8) and many others.
        All longest ordered subsequences are of length 4, e. g., (1, 3, 5, 8).
        Your program, when given the numeric sequence, must find the length of its longest ordered subsequence.

        输入样例                        输出样例
        7
        1 7 3 5 9 4 8                  4
        6
        1 8 3 6 5 9                    4
        5
        1 2 3 4 5                      5
        0 (结束)

提示
        一，对输入字符串的处理

        注意：这道题和其他题的输入输出不同,这题是接收多组数据而非单组,以0来判别结束。大家在接受数据的时候，不要用(c=getchar())!='\n'诸如此类一个字符一个字符接受，
        然后判断是否是回车符号来结束一行的输入，这样的方式在你本机运行不会有问题，但OJ系统中会有错误，无法输出结果，因为测试平台行末并非'\n'字符。
        这里接受数据用scanf的%d或%s，或cin等，会自动判别结束字符的，你就不要在你程序里专门去判别或吸收回车字符。
        对于最后一组数据输入为0表示结束，只要判断接受的第一个字符是否为0且字符串长度为1就结束，无须去处理回车字符。输入的序列可以用整型数组或字符串数组保存。

        二，算法的动态规划思想

        考虑采用动态规划算法，针对每个元素，以该元素结尾的最长有序子序列作为子问题，计算出每个子问题的最大长度用“表”记录下来。先写出递推关系式再编程实现。
        设f(i)表示：从左向右扫描过来直到以a[i]元素结尾的序列，可获得的最长上升子序列的长度，且最长上升子序列包含a[i]元素（1<=i<=n）。

        （这里大家思考一下，为何要这样假设子问题和子问题最优解f(i)？
        有同学问：为何最长上升子序列要包含a[i]元素（1<=i<=n）？因为你所设的子问题要和更下一级子问题关联起来。如果长度为i序列的最长上升
        子序列中没有规定包含a[i]元素，那如何和其前缀的最长上升子序列问题关联起来呢？因为你没法确认你前缀的最长上升子序列最后一个字符在哪里？上升子序列的
        边界在哪不知道的话，很难和更小规模的子问题联系起来，显然是比较麻烦的。）

        f(i)是从f(1),f(2), ……到f(i-1)中找最大的一个值，再加1，或者就是1。这主要得看a[i]这个元素能否加入到之前已经获得的最长上升子序列当中去，
        如果能加入，是之前已获得的最长上升子序列长度加1；如果不能加入，就开始一个新的上升子序列，长度为1。最后，所要求的整个序列的最长上升子序列长度为 max{ f(i): 1<=i<=n }

        f(i)的递推公式如下：
        （1）f(i) = 1              当i=1;
        （2）f(i) = max{f(j)+1}    当i>1, 对某个前面的j(1<=j<i), 有a[j]<a[i]];
        （3）f(i) = 1              当i>1, 对任意j(1<=j<i), 都有a[j]>=a[i]

        例子，对于序列：
        i = 1  2  3  4  5  6  7
        a[i] = 4  2  6  3  1  5  2
        f(i) = 1  1  2  2  1  3  2
        这里max{f(i)}=3为原问题所求的最长上升子序列的长度。

        效率分析：
        f(i)的计算不超过O(n)，因此，整个算法为O(n^2)。*/


public class T_8596 {

    public static int getLongestSeq(int[] a){
        int[] f=new int[a.length];
        for(int i=0;i<a.length;i++){
            //初始化为1 默认自身最小
            f[i]=1;
            //和前面比较
            for(int j=0;j<i;j++){
                if(a[j]<a[i]){
                   f[i]=Math.max(f[i],f[j]+1);
                }
            }

        }

        int max=0;
        for(int i=0;i<f.length;i++){
            if(max<f[i]){
                max=f[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a={4,2,6,3,1,5,2};
        System.out.println(getLongestSeq(a));
    }
}
