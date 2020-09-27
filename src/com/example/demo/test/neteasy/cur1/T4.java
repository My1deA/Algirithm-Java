package com.example.demo.test.neteasy.cur1;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T4 {


    public static int slideWindow(ArrayList<Integer> list){
        Queue<Integer> queue=new LinkedList<>();
        int i=0;
        int max=1;
        queue.offer(list.get(i++));
        while(i<list.size()){
            int t=list.get(i);
            while(!queue.isEmpty() && (t-queue.peek()>=180 || (t-queue.peek()<0 && 360-queue.peek()+t>=180)) ){
                queue.poll();
            }
            queue.add(t);

            if(max<queue.size()){
                max=queue.size();
            }
            i++;

        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int c= scanner.nextInt();
        while(c>0){
            c--;

            ArrayList<Integer> a=new ArrayList<>();
            ArrayList<Integer> a2=new ArrayList<>();
            int n=scanner.nextInt();
            for(int i=0;i<n;i++){
                String x=scanner.next();
                String y=scanner.next();
                if("90S".equals(y)||"90N".equals(y))continue;

                if(x.charAt(x.length()-1)=='E'){
                    a.add(Integer.valueOf(x.substring(0, x.length()-1)));
                }
                else if(x.charAt(x.length()-1)=='W'){
                    a.add(360-Integer.valueOf(x.substring(0, x.length()-1)));
                }else{
                    a.add(Integer.valueOf(x));
                }
            }
            //形成环
            for(int i=0;i<a.size();i++){
                a2.add(a.get(i));
            }
            for(int i=0;i<a.size()-1;i++){
                a2.add(a.get(i));
            }

            System.out.println(slideWindow(a2));
        }


    }
}

/*
-----2
6
0 0
90E 0
180 0
90W 0
0 90S
0 90N

7-----6
0 0
30E 0
60E 0
90E 0
30W 0
60W 0
90W 0
*/
