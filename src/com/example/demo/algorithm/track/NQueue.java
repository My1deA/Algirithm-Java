package com.example.demo.algorithm.track;

import java.util.ArrayList;
import java.util.List;

public class NQueue {
    public List<List<String>> solveNQueens(int n) {
        char[][] chs=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chs[i][j]='.';
            }
        }
        List<List<String>> res=new ArrayList<>();
        backTracing(chs,0,n,res);
        return res;
    }
    public void backTracing(char[][] chs,int row,int n,List<List<String>> res){
        //每行都摆满皇后时，则产生了一种解法
        if(row==n){
            res.add(chsToList(chs));
            return;
        }
        //一行一行地摆放，在确定一行中的那个皇后应该摆在哪一列时，需要当前列是否合法。
        //如果合法，则将皇后放置在当前位置，并进行递归，回溯。
        for(int col=0;col<chs[0].length;col++){
            if(isValid(chs,row,col)){
                chs[row][col]='Q';
                //递归
                backTracing(chs,row+1,n,res);
                //回溯
                chs[row][col]='.';
            }
        }
    }
    public List<String> chsToList(char[][] chs){
        List<String> list=new ArrayList<>();
        for(int i=0;i<chs.length;i++){
            list.add(new String(chs[i]));
        }
        return list;
    }
    //判断合法：当前将要摆放'Q'的位置和其他已摆放‘Q’的位置不能在同一列，且不能在同一条45度斜线或135度斜线上。
    //这里判断是否在同一条斜线上可通过当前将要摆放'Q'的位置和其他已摆放‘Q’的位置横坐标之差和纵坐标之差的绝对值是否相等来判断。
    public boolean isValid(char[][] chs,int x,int y){
        for(int i=0;i<=x;i++){
            for(int j=0;j<chs[0].length;j++){
                if(chs[i][j]=='Q'&&(j==y||Math.abs(x-i)==Math.abs(y-j))){
                    return false;
                }
            }
        }
        return true;
    }
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