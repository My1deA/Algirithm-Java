package com.example.demo.test.bank;

import java.util.Scanner;

public class T1 {

    /**
     * 给N个软件版本号的输入，按照字典序降序排序后输出。
     * @param versions string字符串 N个软件版本号
     * @return string字符串
     */
    public static String sortVersion (String versions) {
        // write code here
        String[] strs=versions.substring(1,versions.length()-1).split(" ");

        for(int i=0;i<strs.length;i++){
            //System.out.print(strs[i]+" ");
            strs[i].trim();
        }

        sort(strs,0,strs.length-1);

        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("\"");
        stringBuffer.append("[");
        //"[6.4, 5.2, 4.5, 3.1, 2.2, 1.0]"

        for(int i=0;i<strs.length;i++){
            //System.out.print(strs[i]+" ");
            if(i!=strs.length-1){
                stringBuffer.append(strs[i]+", ");
            }else{
                stringBuffer.append(strs[i]+"]");
            }

        }
        stringBuffer.append("\"");
        return stringBuffer.toString();

    }

    public static void sort(String[] strs,int left,int right){
        if(left>=right)return;
        int i=left;
        int j=right;
        String t=strs[left];
        while(i<j){
            while(i<j && t.compareTo(strs[j])>=0){
                j--;
            }
            while(i<j && t.compareTo(strs[i])<=0){
                i++;
            }
            swap(strs,i,j);

        }
        strs[left]=strs[i];
        strs[i]=t;
        sort(strs,left,i-1);
        sort(strs,i+1,right);

    }

    public static void swap(String[] strs,int i,int j){
        String t=strs[i];
        strs[i]=strs[j];
        strs[j]=t;
    }


    //"3.1 2.2 1.0 6.4 4.5 5.2"
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(sortVersion(str));
    }



}
