package com.example.demo.algorithm.part_3;

// 17082 两个有序数序列中找第k小
/*Description
        已知两个已经排好序（非减序）的序列X和Y，其中X的长度为m，Y长度为n，现在请你用分治算法，找出X和Y的第k小的数，算法时间复杂度为O(max{logm, logn})。

        此题请勿采用将序列X和Y合并找第k小的O(m+n)的一般方法，要充分利用X和Y已经排好序的这一特性。

        输入格式
        第一行有三个数，分别是长度m、长度n和k，中间空格相连（1<=m,n<=100000; 1<=k<=m+n）。
        第二行m个数分别是非减序的序列X。第三行n个数分别是非减序的序列Y。

        输出格式
        序列X和Y的第k小的数。

        输入样例                    输出样例
        5 6 7                       20
        1 8 12 12 21
        4 12 20 22 26 31

        提示
        假设：X序列为X[xBeg...xEnd]，而Y序列为Y[yBeg...yEnd]。

        将序列X和Y都均分2段，即取X序列中间位置为xMid (xMid = xBeg+(xEnd-xBeg)/2)，也同理取序列Y中间位置为yMid。
        比较X[xMid]和Y[yMid]的大小，此时记录X左段和Y左段元素个数合计为halfLen，即halfLen = xMid-xBeg+yMid-yBeg+2。

        1. 当X[xMid] < Y[yMid]时，在合并的数组中，原X[xBeg...xMid]所有元素一定在Y[yMid]的左侧，
        （1） 若k < halfLen，则此时第k大的元素一定不会大于Y[yMid]这个元素，故以后没有必要搜索 Y[yMid...yEnd]这些元素，可弃Y后半段数据。
        此时只需递归的对X序列+Y序列的前半段，去搜索第k小的数。

        （2） 若k >= halfLen，则此时第k大的元素一定不会小于X[xMid]这个元素，故以后没有必要搜索 X[xBeg...xMid]这些元素，可弃X前半段数据。
        此时只需递归的对X序列的后半段+Y序列，去搜索第 k-(xMid-xBeg+1）小的数。

        2. 当X[xMid] >= Y[yMid]时，在合并的数组中，原Y[yBeg...yMid]的所有元素一定在X[xMid]的左侧，
        （1） 若k < halfLen，则此时第k大的元素一定不会大于X[xMid]这个元素，故以后没有必要搜索 X[xMid...xEnd]这些元素，可弃X后半段数据。
        此时只需递归的对X序列的前半段+Y序列，去搜索第k小的数。

        （2） 若k >= halfLen，则此时第k大的元素一定不会小于Y[yMid]这个元素，故以后没有必要搜索 Y[yBeg...yMid]这些元素，可弃Y前半段数据。
        此时只需递归的对X序列+Y序列的后半段，去搜索第 k-(yMid-yBeg+1）小的数。*/



public class T_17082_H {
}


/*
#include <stdio.h>
#include <stdlib.h>
#define maxn 100010
int a[maxn], b[maxn], k;

int f(int la,int ra,int lb,int rb)
{
    int halflen, ma, mb;
    if(lb > rb) return a[la+k-1];//递归边界
    if(la > ra) return b[lb+k-1];//递归边界
    ma = (ra + la) / 2;
    mb = (rb + lb) / 2;
    halflen = ma - la + mb - lb + 2;
    if(a[ma] < b[mb])
    {
        if(k < halflen) return f(la, ra, lb, mb-1);
        k -= (ma - la + 1);
        return f(ma + 1, ra, lb, rb);
    }
    else
    {
        if(k < halflen) return f(la, ma-1, lb, rb);
        k -= (mb - lb + 1);
        return f(la, ra, mb + 1, rb);
    }
}

int main()
{
    int m,n,i;

    scanf("%d%d%d",&m,&n,&k);
    for(i = 0; i < m; i++)
        scanf("%d", &a[i]);
    for(i = 0; i < n; i++)
        scanf("%d", &b[i]);
    printf("%d\n",f(0, m-1, 0, n-1));
    return 0;
}
 */