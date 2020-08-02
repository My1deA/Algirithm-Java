package com.example.demo.algorithm.recursion;

// 11087 统计逆序对 recursion
/*在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
示例 1:
        输入: [7,5,6,4]
        输出: 5
限制：
        0 <= 数组长度 <= 50000*/
public class T_11087_H {

    public int countInversion(int []arr,int left,int right) {
        if(left >= right) {
            return 0;					//递归出口
        }
        int mid = (int)((left+right)/2);
        int countLeft = countInversion(arr,left,mid);     //先左边递归
        int countRight = countInversion(arr,mid+1,right);     //再右边递归
        int countMerge = mergeInversion(arr,left,mid,right);	 	//调用排序函数
        return countLeft+countRight+countMerge;
    }
    public int mergeInversion(int []arr,int left,int mid, int right) {
        int i = left ,j = mid+1 ,tempIndex = left;				//i指向左半边，j指向右半边
        int count = 0;
        int []tempArr = arr.clone();
        while(i <= mid && j <= right) {
            if(tempArr[i]>tempArr[j]) {
                arr[tempIndex] = tempArr[j];
                count = count+right-j+1;    //统计逆序对个数
                j++;
                tempIndex++;
            }
            else {
                arr[tempIndex] = tempArr[i];
                i++;
                tempIndex++;
            }
        }
        if(i<=mid)
            count--;				//因为当右半边完时，左半边判断的指针未后移，在下面第一个while处会多自增一次，所以在这里先自减
        while(i<=mid) {				//左边还没有完，右边已完
            arr[tempIndex] = tempArr[i];
            count++;
            i++;
            tempIndex++;
        }
        while(j<=right){
            arr[tempIndex] = tempArr[j];  //右边还没有完，左边已完
            j++;
            tempIndex++;
        }
        return count;
    }


}
