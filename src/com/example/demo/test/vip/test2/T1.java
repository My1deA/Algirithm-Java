package com.example.demo.test.vip.test2;


/*输入两个字符串a和b，字符串内容为二进制数字，求两个字符串相加的结果，加法计算方法以二进制方式计算，并返回对应的字符串结果。要求程序尽可能的高效。示例如下：

输入描述:
        输入两个字符串，如"1101", "1100"

输出描述:
        "11001"

输入例子1:
        1101 1100

输出例子1:
        11001
*/


import java.util.Scanner;

public class T1 {

    public static String add(String a, String b){
        StringBuffer stringBuffer=new StringBuffer();
        Integer a1=Integer.parseInt(a);
        Integer b1=Integer.parseInt(b);
        int carry=0;
        while(a1!=0 || b1!=0 || carry!=0 ){
            int e1=a1%10;
            a1=a1/10;

            int e2=b1%10;
            b1=b1/10;

            int sum=e1+e2+carry;
            if(sum>=2){
                carry=1;
                sum=sum-2;
            }else{
                carry=0;
            }

            stringBuffer.append(sum);
        }

        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.next();
        String b=scanner.next();
        System.out.println(add(a,b));
    }
}
