package com.example.demo.pass.test.huiliang;


import java.util.ArrayList;
import java.util.Scanner;

public class T1 {

    static class Item{
        String all;
        String name;
        String start;
        String cost;

        @Override
        public String toString() {
            return this.all;
        }
    }

    public static void quickSort(ArrayList<Item> a,int left,int right){
        if(left>=right)return;
        int i=left;
        int j=right;
        Item t=a.get(left);
        while(i<j){
            while(i<j && (t.cost.compareTo(a.get(j).cost) < 0 || (t.cost.compareTo(a.get(j).cost)==0 && t.start.compareTo(a.get(j).start)<0))){
                j--;
            }
            while(i<j && (t.cost.compareTo(a.get(i).cost) > 0 || (t.cost.compareTo(a.get(i).cost)==0 && t.start.compareTo(a.get(i).start)>0))){
                i++;
            }
            swap(a,i,j);

        }
        //a.set(left,a.get(i));
        a.set(i,t);

        quickSort(a,left,i-1);
        quickSort(a,i+1,right);

    }

    public static void swap(ArrayList<Item> a,int i,int j){
        Item t=a.get(i);
        a.set(i, a.get(j));
        a.set(j,t);
    }

    public static void main(String[] args) {
        ArrayList<Item> a=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);

        while(true){
            Item item=new Item();
            item.all=scanner.nextLine();
            if("".equals(item.all.trim())){break;}

            String[] strings=item.all.trim().split(" ");
            item.name=strings[0];
            item.cost=strings[strings.length-1];
            StringBuffer stringBuffer=new StringBuffer();
            for(int i=1;i<strings.length-1;i++){
                stringBuffer.append(strings[i]);
            }
            item.start=stringBuffer.toString();

            a.add(item);

        }

        quickSort(a,0,a.size()-1);

        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
    }
}




























