package com.example.demo.algorithm.track;

public class NQueue {
}

/*
#include<iostream>
#include<stdlib.h>
using namespace std;
bool place(int k,int *x)
{
    int i=1;
    while(i<k)
    {
        if((x[i]==x[k]) || abs(x[i]-x[k])==abs(i-k))//若第k行的皇后列位置与之前每一行皇后都不在同一列或不在同一斜线上
            return false;
        i++;
    }
    return true;
}
void nqueens(int n,int *x)
{
    int k=1;
    x[1]=0;
    while(k>0)
    {
        x[k]=x[k]+1; //依次验证该行（第k行）的每一列
        while(x[k]<=n && !place(k,x)) //不符合条件的马上取该行下一列判断，符合条件则跳出该循环
            x[k]=x[k]+1;
        if(x[k]<=n)   //找到了一个位置，而且是合法的
        {
            if(k==n)  //判断是不是最后一个皇后，若是则得出一个完整解
            {
                for(int i=1; i<=n; i++)
                    cout<<x[i]<<' ';
                    cout<<endl;
            }
            else    //若不是最后一个皇后，则转到下一行，给下一个皇后找位置
            {
                k=k+1;
                x[k]=0;
            }
        }
        else
            k=k-1;//若是找了第k行全部的列都无法放置某个皇后，则回溯到上一行k的情况，到该行下一列；
    }
}
int main()
{
    int n; //定义皇后的个数
    cout<<"please enter the queens number:"<<endl;
    cin>>n;
    int *x=new int[n];
    nqueens(n,x);
    return 0;
}


 */