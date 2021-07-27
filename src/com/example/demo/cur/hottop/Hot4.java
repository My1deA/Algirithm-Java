package com.example.demo.cur.hottop;

public class Hot4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        //中位数 k是指第几个数 而不是下标 是下标+1
        int k=(m+n)/2;
        //偶数
        if((m+n)%2==0){
            double left=find(nums1,0,nums2,0,k);
            double right=find(nums1,0,nums2,0,k+1);
            return (left+right)/2;
        }else{//奇数
            return find(nums1,0,nums2,0,k+1);
        }

    }
    // al：a数组的左下标   bl: b数组的左下标
    public static double find(int [] a,int al, int [] b,int bl,int k){
        // a 数组已经遍历完
        if(al==a.length){
            return b[bl+k-1];
        } else if(bl==b.length){ // b 数组已经遍历完
            return a[al+k-1];
        }if(k==1){// ab 数组长度均为1
            return  Math.min(a[al],b[bl]);
        }else{
            //新的开始下标
            int al2, bl2;
            if(al+k/2>=a.length){
                al2=a.length-1;
            }else{
                al2=al+k/2-1;
            }
            if(bl+k/2>=b.length){
                bl2=b.length-1;
            }else{
                bl2=bl+k/2-1;
            }
            if(a[al2]<=b[bl2]){
                return find(a,al2+1,b,bl,k-(al2-al+1));
            }else{
                return find(a,al,b,bl2+1,k-(bl2-bl+1));
            }

        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }


}

/*
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 0)
        {

            return (get_loction(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2) + get_loction(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2 + 1)) / 2.0;
        }
        else
        {
            return (double) get_loction(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2 + 1);
        }
    }


public int get_loction(int[] nums1, int[] nums2, int begin1, int begin2, int k)
{
    if (begin1 == nums1.length)
    {
        return nums2[begin2 + k - 1];
    }
    else if (begin2 == nums2.length)
    {
        return nums1[begin1 + k - 1];
    }
    else if (k == 1)
    {
        return nums1[begin1] < nums2[begin2] ? nums1[begin1]: nums2[begin2];
    }
    else
    {
        int end1, end2;
        if (begin1 + k / 2 - 1 >= nums1.length)
        {
            end1 = nums1.length - 1;
        }
        else
        {
            end1 = begin1 + k / 2 - 1;
        }
        if (begin2 + k / 2 - 1 >= nums2.length)
        {
            end2 = nums2.length - 1;
        }
        else
        {
            end2 = begin2 + k / 2 - 1;
        }
        if (nums1[end1] <= nums2[end2])
        {
            return get_loction(nums1, nums2, end1 + 1, begin2, k - end1 - 1 + begin1);
        }
        else
        {
            return  get_loction(nums1, nums2, begin1, end2 + 1, k - end2 - 1 + begin2);
        }
    }
}
}

 */