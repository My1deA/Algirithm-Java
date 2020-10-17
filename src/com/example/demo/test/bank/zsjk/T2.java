package com.example.demo.test.bank.zsjk;

public class T2 {


    public static int getIndex(int[] nums,int target){
        int index=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                index=mid;
                //System.out.println(index+" "+left +" "+ right);
                break;
            }
            else if(nums[mid]<nums[left]){
                if(target <= nums[left] && target >= nums[mid]){
                    right=mid;
                }else if(target > nums[left] || target <= nums[mid]){
                    left=mid;
                }
            }else if(nums[mid]>nums[left]){

                if(target <= nums[mid] && target >= nums[right]){
                    left=mid;
                }else if(target < nums[left] || target >= nums[mid]){
                    right=mid;
                }
            }else{
                left++;
            }
            //System.out.println(left +" "+mid+" "+ right);
        }

        return index;
    }



    public static void main(String[] args) {
        int[] nums={4,3,2,1,6,5};
        //int[] nums2={1,6,5,4,3,2};
        System.out.println(getIndex(nums,1));

    }


    public static int getIndex2(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
