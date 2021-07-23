package com.example.demo.pass.algorithm.dp;

//8595 钱币组合的问题（必做) （dp）

/*Description:
        设有n种不同的钱币各若干，可用这n种钱币产生许多不同的面值。 如给定面值7分，有1分3张，2分3张，5分1张，能组成给定面值7分的方法有如下4种：
        3个1分+2个2分； 5个； 1个1分+3个2分； 4个； 2个1分+1个5分； 3个； 1个2分+1个5分； 2个。 上面4种方案的最少张数为2个。 你的编程任务：
        给定面值m，和n种不同钱币及其张数， （1） 求给定面值m能有多少种不同的构成方法数。 （2） 求给定面值m最少要多少张。

输入格式
        第1行有1个正整数n(1<=n<=50)，表示有n种不同的钱币。 第2行有n个数，分别表示每种钱币的面值v[1]...v[n](0<=v[i]<=100,1<=i<=n)。
        第3行有n个数，分别表示每种钱币的张数k[1]...k[n](0<=k[i]<=100,1<=i<=n)。 第4行有1个数，表示给定的面值m (1<=m<=20000)。

输出格式
        两行： 第一行：计算出给定面值的不同的方法种数。若无法给出找钱方案，返回0数值。 第二行：计算出给定面值所需的最少张数。
        若无法给出找钱方案，返回“no possible”(无大写，无标点)。

输入样例
        3
        1 2 5
        3 3 1
        7

输出样例
        4 2

提示
       1）给定面值m的不同方法种数
       给定的总面值m，n种钱币，每种钱币面值v[1...n],每种钱币的张数k[1...n]，用一个二维数组d[i][1...m]记录用前i种钱币组成1...m面值产生的方法数。1<=i<=n。
       初始，该数组全清零，然后逐个加入第i种面值的钱币（1<=i<=n），并修改影响到数组d的方法数。设d[i,j]:表示前i种钱币组成面值j分的方法数，1<=i<=n,0<=j<=m。(j>=0才有意义，若j<0,可视为d[i,j]=0)
        d[i,0] = 1,  if 1<=i<=n
        d[1,j] = 1,  if j%v[1]=0 && j/v[1]<=k[1];
        d[1,j] = 0,  if j%v[1]!=0 || j/v[1]>k[1] || j<0;

        if i>1 && j1 && v[i]<=j<2*v[i]
        d[i,j] = d[i-1,j] + d[i-1,j-v[i]]

        if i>1 && 2*v[i]<=j<3*v[i]
        d[i,j] = d[i-1,j] + d[i-1,j-v[i]] + d[i-1,j-2*v[i]
        if i>1 && k[i]*v[i]<=j<=m
        d[i,j] = d[i-1,j] + d[i-1,j-1*v[i]] + d[i-1,j-2*v[i]] + ... + d[i-1,j-k[i]*v[i]]
     //这里要注意，要保证 j-k[i]*v[i]>=0 才有意义，对可能的越界（无论是左边越界还是右边越界），都要仔细审查。最后d[n,m]为原问题所求。
        当然由于这里的d数组d[i,j]只与d[i-1,...]有关，也完全可以用一维数组d[1...m]来实现。

    （2）求给定面值m最少要多少张
    假设c[i][j]表示：选择前i种面值的钱，凑成面值j的最少张数，这里1<=i<=n, 0<=j<=m。c[i][j]的递归关系如下：令：t = min{ (int)(j/v[i]), k[i] }，表示第i种钱币最多加入的张数。
    c[i][j] = min{ p+c[i-1][j-p*v[i]] | p from 0 to t }，这里p表示第i种币值选入的张数，t表示第i种币值最多选入的张数。//这里要注意，要保证 j-p*v[i]>=0 才有意义，对可能的越界（无论是左边越界还是右边越界），都要仔细审查。

    初始条件：
        c[i][0]=0, 1<=i<=n
        c[1][j]=int(j/v[1]),   if j%v[1]==0 && j/v[1]<=k[1]
        c[1][j]=MAXINT,        if j%v[1]!=0 || j/v[1]>k[1]
      //此处MAXINT为自定义的无穷大的数，表示没法放。最后返回c[n][m]，若c[n][m]为MAXINT，则无法找到找钱的方案。、*/
public class T_8595 {

    //1）给定面值m的不同方法种数
    public static int getMethodNum(int[] v,int [] k,int n){
        //d[i][1...m]记录用前i种钱币组成1...m面值产生的方法数。1<=i<=n
        int[][] d=new int[v.length][n+1];
        //面额为0 默认都是1
        for(int i=0;i<v.length;i++){
            d[i][0]=1;
        }
        //初始化 第一种面额 组成 面值
        for(int j=1;j<=n;j++){
            // j是v[i]倍数 并且 j/v[1]小于此面额的总数
            if(j%v[0]==0 && j/v[0]<=k[0]){
                d[0][j]=1;
            }else{
                d[0][j]=0;
            }
        }

        //从 钱2种面额 开始
        //d[i,j] = d[i-1,j] + d[i-1,j-1*v[i]] + d[i-1,j-2*v[i]] + ... + d[i-1,j-k[i]*v[i]]
        for(int i=1;i<v.length;i++){
            for(int j=1;j<=n;j++){
                //遍历 k[i] 看 j能大于几倍(p)的 v[8] 如果k[i]==0 就将前面几种面额组成j的值直接给d[i][j]
                for(int p=0;p<=k[i];p++){
                    // p*v[i] > j 就结束
                    if(p*v[i]>j)break;
                    //等于 前i-1面额组成 j-p*v[i]的面值
                    d[i][j]+=d[i-1][j-p*v[i]];
                }
            }
        }

        return d[v.length-1][n];
    }

    //（2）求给定面值m最少要多少张
    public static int getMethodNum2(int[] v,int [] k,int n){
        int MaxInt=9999;//需要自己定义 无法用Integer.MaxValue 因为MaxValue+p会溢出变负数

        // j一定从 1开始
        int[][] c=new int[v.length+1][n+1];
        //如果 n==0 就 都为0；
        for(int i=0;i<v.length;i++){
            c[i][0]=0;
        }

        //初始化 第1个面额
        for(int j=1;j<=n;j++){
            //j能整除 v[0] & 所需要的的v[0] <= 目前拥有的
            if(j%v[0]==0 && j/v[0]<=k[0]){
                c[0][j]=j/v[0];
            }else{
                c[0][j]=MaxInt;
            }
        }

        //从 前2个面额开始
        for(int i=1;i<v.length;i++){
            for(int j=1;j<=n;j++){
                int min=MaxInt;
                for(int p=0;p<=k[i];p++){
                    if(p*v[i]>j)break;
                    //前 i-1面额 组成 j面额 + 当前
                    int t=p+c[i-1][j-p*v[i]];
                    //System.out.println(i+" " + j + +c[i-1][j-p*v[i]]+" "+p);
                    if(t<min){
                        min=t;
                    }
                }
                c[i][j]=min;
            }
        }

        //如果 c[v.length-1][n-1]为 MaxInt 无解
        return c[v.length-1][n];
    }

    public static void main(String[] args) {
        int[] v={1,2,5};
        int[] k={3,3,1};
        int n=7;
        System.out.println(getMethodNum(v,k,n));
        System.out.println(getMethodNum2(v,k,n));
    }
}
























