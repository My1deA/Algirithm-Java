package com.example.demo.pass.algorithm.undone;

// 11091 最优自然数分解 贪心
/*Description
        问题描述：设n是一个正整数。
        （1）现在将n分解为若干个互不相同的自然数之和，且使这些自然数的乘积最大。
        （2）现在将n分解为若干个自然数之和，且使这些自然数的乘积最大。
        编程任务：对于给定的正整数n，编程计算问题（1）和（2）的最优分解的最大乘积。

        注意：
        这里的自然数不含0但包含1。
        特别地，当整数n无法分解为若干互不相同的加数时，即自身视为单独的一个加数，比如输入2，问题（1）的解输出为2。
        而如果整数n可以分解为若干互不相同的加数时，不考虑自身为单独加数的情况，比如4，问题（1）的解输出为3，而非4。

        输入格式 只有一个正整数n(1<=n<=100)。

        输出格式 输出待解问题（1）和（2）的最大乘积，中间空格相连，这两个数可能较大请用64位整数。
        如，输入n为10，若加数互不相同，则n=2+3+5，此时最大乘积为2*3*5=30。
        若加数可相同，则n=2+2+3+3，此时最大乘积为2*2*3*3=36。

        输入样例        输出样例
        10              30 36

        提示
        分析：
        注意无论是（1）还是（2），乘积皆用64位整数表示。

        （1）分解为互不相同自然数之和
        注意到： 若a+b等于一个常数，则|a-b|越小，ab就越大。
        要使得加数互不相同，又尽可能集中，那加数只能是连续的自然数了。

        贪心策略：将n分成从2开始的连续的自然数的和。如果最后剩下一个数，将此剩余数在后项优先的方式下均匀地分给前面各项。

        （2）分解为若干自然数之和
        注意到： 若a+b等于一个常数，则|a-b|越小，ab就越大。
        若 n = m1+m2+...+mk，则 -1 <= (mi-mj) <= 1，（1<=i<=k， 1<=j<=k），即任意加数的差距不超过正负1。
        由于拆分的加数可以相同，任何一个数拆后乘积总比不拆强，因此拆到极尽，极尽的加数为3或2，且拆为3比拆为2好，因此优先拆为3。

        贪心策略：极尽拆解，尽可能先将n拆成3,3,3,...,3；若拆成若干3后还有剩余，则为2，或2和2。

        归纳公式如下：
        1)max{m1*m2*...*mk} = 3^(n/3)        if n(mod 3)等于0
        2)max{m1*m2*...*mk} = 4*3^[(n-4)/3]  if n(mod 3)等于1
        3)max{m1*m2*...*mk} = 2*3^[(n-2)/3]  if n(mod 3)等于2

        */



public class T_11091 {

}


/*
#include <iostream>
#include <math.h>
using namespace std;

int n;
long long ans=1;

long long fun1(int n);
long long fun2(int n);

int main()
{
    cin>>n;
    cout<<fun1(n)<<" "<<fun2(n)<<endl;
    return 0;
}

long long fun2(int n){
    if(n%3==0){
        return  pow(3,n/3);
    }else if(n%3==1){
        return 4*pow(3,(n-4)/3);
    }else if(n%3==2){
        return 2*pow(3,(n-2)/3);
    }

}


long long fun1(int n){
    if(n<=4){
        if(n<=2){
             return n;
        }else{
            return n-1;
        }

    }

    int sum1=0;
    int j=1;
    int item=2;
    int sum[1000]={0};
    while(1){
        sum1+=item;
        if(sum1>n){
            j--;
            break;
        }else if(sum1==n){
            sum[j]=item;
            break;
        }
        sum[j++]=item++;
    }

    if(sum1==n){
        for(int i=1;i<=j;i++){
            ans*=sum[i];
        }
    }else{
        int more=n-(sum1-item);
        int add=more/j;
        if(add==0){
            for(int p=j;p>j-more;p--){
                sum[p]=sum[p]+1;
            }
        }else if(add==1){

            for(int p=j;p>=1;p--){
                sum[p]=sum[p]+1;
            }
            for(int p=j;p>2*j-more;p--){
                sum[p]=sum[p]+1;
            }
        }
         for(int i=1;i<=j;i++){
            ans*=sum[i];
        }
    }
    return ans;
}


 */