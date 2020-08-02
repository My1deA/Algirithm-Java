package com.example.demo.algorithm.undone;

// 8601 最大长方体问题 dp
/*Description
        一个长,宽,高分别是m,n,p的长方体被分割成m*n*p个小立方体。每个小立方体内含一个整数。试着设计一个算法，计算所给长方体的最大子长方体。
        子长方体的大小由它内部所含所有整数之和确定约定：当该长方体所有元素均为负数时,输出最大子长方体为0。

        Input
        第一行3个正整数m,n,p，其中 1<=m,n,p<=50
        接下来的m*n行中每行p个整数，表示小立方体中的数。

        Output
        第一行中的数是计算出的最大子长方体的大小。

        Sample Input
        3 3 3
        0 -1 2
        1 2 2
        1 1 -2
        -2 -1 -1
        -3 3 -2
        -2 -3 1
        -2 3 3
        0 1 3
        2 1 -3

        Sample Output
        14

        Hint
        1，先编写一维的“最大字段和”的解法。
        2，基于“最大字段和”，编写二维的“最大子矩阵和”的解法。
        3，基于“最大子矩阵和”，编写三维的“最大子长方体和”的解法。*/



public class T_8601 {
}


/*
#include <iostream>

using namespace std;


int MaxSum1(int *a,int n);
int MaxSum2(int **a,int m,int n);
int MaxSum3(int ***a,int m,int n,int p);

int main()
{
    int m,n,p;
    cin>>m>>n>>p;
    int ***a=new int **[m];
    for(int i=0;i<m;i++)
    {
        a[i]=new int *[n];
        for(int j=0;j<n;j++)
            a[i][j]=new int [p];
    }

    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<p;k++){
                cin>>a[i][j][k];
            }
        }

    }

    cout<<MaxSum3(a,m,n,p);

    return 0;
}


int MaxSum1(int *a,int n){
    int sum=0;
    int b=0;
    for(int i=0;i<n;i++){
        if(b>0){
            b+=a[i];
        }else{
            b=a[i];
        }
        if(sum<b){
            sum=b;
        }
    }
    return sum;

}
int MaxSum2(int **a,int m,int n){
    int sum=0;
    int *b=new int [n+1];

    for(int i=0;i<m;i++){
        for(int k=0;k<n;k++){
            b[k]=0;
        }

        for(int j=i;j<m;j++){
            for(int k=0;k<n;k++){
                b[k]+=a[j][k];
            }
            int max2=MaxSum1(b,n);
            if(sum<max2){
                sum=max2;
            }
        }
    }
    return sum;
}


int MaxSum3(int ***a,int m,int n,int p){
    int sum=0,max3=0;
    int **b=new int*[n];
    for(int i=0;i<n;i++)
        b[i]=new int[p];

    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<p;k++){
                b[j][k]=0;
            }
        }

        for(int j=i;j<m;j++){
            for(int k=0;k<n;k++){
                for(int q=0;q<p;q++){
                    b[k][q]+=a[j][k][q];
                }
            }
            max3=MaxSum2(b,n,p);
            if(sum<max3){
                sum=max3;
            }
        }
    }
    return sum;
}

 */