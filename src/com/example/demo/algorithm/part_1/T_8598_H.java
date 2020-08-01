package com.example.demo.algorithm.part_1;

// 8598 整除15问题 贪心

/*Problem
        给定一个只包含数字 [0..9] 的字符串，求使用字符串中的某些字符，构造一个能够被15整除的最大整数。注意，字符串中的每个字符最多只能使用一次。
        输入：程序从标准输入读入数据，每行数据由一串数字组成，长度为1到1000。 输出：针对每一行输入，输出一个结果，每个结果占一行。如果无法构造出能够被15整除的整数，请输出impossible

        test input      test output
        1               impossible
        01431           43110
        103             30*/


/*
#include <iostream>
#include <string.h>
using namespace std;

bool debug = false;

char str[2000];
//numberCount[i]表示数字i出现的个数
int numberCount[12];
//字符串长度
unsigned int totalNumbers;

//所有位数上的数字和
unsigned int res = 0;
//余1
unsigned int res1Count = 0;

unsigned int res2Count = 0;


int del1(){
    for (int i =1; i<8; i+=3) {
        if (numberCount[i]) {
            numberCount[i]--;
            totalNumbers--;
            res1Count--;
            res-=i;
            return 1;
        }
    }
    return 0;

}
int del2(){
    for (int i =2; i<9; i+=3) {
        if (numberCount[i]) {
            numberCount[i]--;
            totalNumbers--;
            res2Count--;
            res-=i;
            return 1;
        }
    }
    return 0;
}


void delNumbers(){
    if (res%3==1) {
        if (res1Count) {
            del1();
            return;
        }
        else if (res2Count>1) {
            if (numberCount[0]) {
                del2();
                del2();
                return;
            }
           else if (numberCount[5]==0) {
                return;
            }
            else if (numberCount[5]) {

                numberCount[5]--;
                res2Count--;
                if (res2Count >1) {
                    del2();
                    del2();
                }
                numberCount[5]++;
                res2Count++;
                return;
            }
            else return;

        }
        else return;
    }

     else if (res%3==2) {

        if (res2Count) {

            if (numberCount[0]) {
                del2();
                return;
            }
           else if (numberCount[5]) {

               numberCount[5]--;
               res2Count--;
               if (res2Count>0) {
                   del2();
                   numberCount[5]++;
                   res2Count++;
                   return;
               }
               numberCount[5]++;
               res2Count++;

            }

        }

         if (res1Count>1) {
            del1();
            del1();
            return;

        }
         else  return;
    }

}

void reSet(){
    res=0;
    res1Count=0;
    res2Count=0;
    memset(numberCount, 0, sizeof(numberCount));
    //总字符个数
    totalNumbers = strlen(str);

    //统计每个数字出现的个数
    for (int i = 0; i<totalNumbers; i++)numberCount[str[i] - '0']++;

    for (int i =0; i<10; i++) {

        res += i * numberCount[i];

        if (i%3==1) {
            res1Count += numberCount[i];
        }
        if (i%3==2) {
            res2Count += numberCount[i];
        }


    }
}
void output(){
    //res % 3 余 0
    if (res % 3 == 0 && totalNumbers!=0) {
        //如果有0从大到小输出
        if (res==0) {
            cout<<0<<endl;
        }
        else if (numberCount[0]) {
            for (int i = 9; i>=0; i--) {
                for (int j = numberCount[i]; j>0; j--) {
                    cout << i ;
                }
            }
            cout<<endl;
        }
        //如果有5
        else if (numberCount[5]){
            for (int i = 9; i>=0; i--) {
                for (int j = numberCount[i]; j>0; j--) {
                    if (i == 5 && j == 1){
                        continue;
                    }else {
                        cout<<i;
                    }
                }
            }
            cout<<5<<endl;
        }
        //没有0也没有5 impossable
        else{
            cout<<"impossible"<<endl;
        }
    }
    //不够删除多余的数字
    else{
        cout<<"impossible"<<endl;
    }

    if(debug)cout << " res = "<<res<<" res1= "<<res1Count<<" "<<res2Count<< endl;
}
int main(int argc, const char * argv[]) {

    while(scanf("%s",str) != EOF){


        reSet();
        //没有0也没有5
        if (numberCount[0]==0 && numberCount[5]==0){
            cout<<"impossible"<<endl;
            continue;
        }

        //判断并删除多余的数
        delNumbers();

        output();

        if (debug) {
            for (int i=0; i<10; i++) {
            cout << i << "="<< numberCount[i] <<endl;
            }
        }

    }

    return 0;
}

 */


public class T_8598_H {
}

