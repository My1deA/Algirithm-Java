package com.example.demo.pass.test.neteasy.test2;

import java.util.HashMap;
import java.util.Scanner;

public class T4 {
    private static HashMap<String,Integer> map=new HashMap<>();
    private static int[] ans=new int[80001];

    private static Integer getCount(String str){
        return map.get(str);
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        while(n-->0){
            String str=scanner.next();
            if(!map.containsKey(str)){
                map.put(str,1);
            }else{
                map.put(str,map.get(str)+1);
            }
        }
        int index=0;
        while(m-->0){
            String str=scanner.next();
            Integer t=map.get(str);
            if(t==null){
                ans[index++]=0;
            }else{
                ans[index++]=t;
            }
        }

        for(int i=0;i<index;i++){
            System.out.println(ans[i]);
        }

    }

}
