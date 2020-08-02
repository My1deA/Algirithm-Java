package com.example.demo.algorithm.dp;

// 11090 最大M段乘积和最小m段和 dp
/*Description
        一个n位十进制整数S，若将S划分为m个段，则可以得到m个整数。
        (1)这m个整数的乘积称为S的一个“m段乘积”，对于给定的S和m，求S的最大m段乘积。
        (2)这m个整数的和称为S的一个“m段和”，对于给定的S和m，求S的最小m段和。

        输入格式
        输入：三个整数，n,m,S。
        第一个n表示S的位数，第二个m表示分割的段数，第三个数为需要被分段的n位十进制数S。
        n、m和S三个数中间空格相连，这里1<=m<=n,n<=10，即S、S的最大m段乘积、S的最小m段和这三个
        数都用int型即可，虽然输出的数可能很大，但这里32位整数够了，测试数据没有超过32位整数,即
        无需考虑多位的高精度数。

        例如，十进制数3456的“最大3段乘积”为1020。因为3456划分3个段有如下情形：
        3456=672，3456=810，3456=1020。
        3456的“最小3段和”为45，因为3+4+56=63，3+45+6=54，34+5+6=45。

        输出格式
        输出：
        第一行计算出的最大m段乘积和最小m段和，中间空格相连。
        第二行写出最大m段乘积的乘法表达式。
        第三行写出最小m段和的加法表达式。

        这里约定：
        （1）若有多种分段方法使得最大m段乘积相等且都最大，则优先输出靠左的段更短小的这种方式。
        比如输入3 2 111，这里最大m段乘积的乘法表达式为：111=11，而不要输出111=11
        （2）若分出的某段数字有0开头的，不输出0。
        比如输入5 3 20001，这里输出：201=0，（其实代表着：20001，这里001，只写1即可）
        （3）若只分一个段，表达式也就写1个段的数等于某个数。
        比如输入2 1 12，输出：12=12
        （4）最小m段和的加法表达式也同样满足前面的约定（1）（2）（3）。

        输入样例
        4 3 3456

        输出样例
        1020 45
        3456=1020
        34+5+6=45

        提示
        这是一个动态规划的问题。先来看最大m段乘积，最小m段和的计算是同理的。

        设w(h,t)是S从h位开始的共t位数字组成的十进制数，约定从1开始从左向右对位进行编号，
        即最左一位定为第1位。
        f(i,j)表示S的前i位数划分成j段后的最大j段乘积。
        t(i,j)表示S的前i位数划分成j段后的最小j段和。
        无论是f(i,j)还是t(i,j)，这里只考虑i>=j的情况，因为每个段至少1位，因此i必然大于等于j。
        显然f(i,j)和t(i,j)都具有最优子结构。

        一、最大m段乘积的动态规划递归式
        边界： 当j=1时，f(i,1) = w(1,i)， 1<=i<=n 表示当只划分1个段时，最大段乘积
        就是从第1位开始共i位数（i>=1）的十进制数值。

        当j>=2时，计算f(i,j)的动态规划的递归式如下：
        f(i,j) = max{ f(k, j-1) * w(k+1, i-k) | k from j-1 to i-1 } j>=2 && j<=i<=n
        (即让k从j-1到i-1变化，找f(k, j-1)和w(k+1, i-k)乘积的最大值)

        这个公式这样理解：
        当 j>=2 && j<=i<=n 时，现在要求解的问题是前i位划分为j个段的最大j段乘积，
        这时考虑前k位，划分j-1个段（因为最后一个段至少占1位，而前j-1个段又至少有j-1位，所以 j-1 <= k <= i-1），
        先获得这j-1个段的最大段乘积，再乘以从第k+1位到第i位（共i-k位，这是最后一个段，即第j个段）的十进制数，
        让k从j-1到i-1循环，求f(k, j-1)和w(k+1, i-k)乘积的最大值。

        二、最小m段和的动态规划递归式
        最小m段和公式的分析和最大m段乘积的公式分析是相同的。

        边界： 当j=1时，t(i,1) = w(1,i)， 1<=i<=n 表示当只划分1个段时，最小段和就是从第1位开始共i位
        数（i>=1）的十进制数值。

        当j>=2时，计算t(i,j)的动态规划的递归式如下：
        t(i,j) = min{ t(k, j-1) + w(k+1, i-k) | k from j-1 to i-1 } j>=2 && j<=i<=n
        (即让k从j-1到i-1变化，找t(k, j-1)和w(k+1, i-k)之和的最小值)

        三、思考
        如何获得“最大m段乘积的乘法表达式”和“最小m段和的加法表达式”呢？*/



/*

int getNum(int s,int len);
int maxProduct(int m,int n);
int minSum(int m,int n);


int main()
{
    //cout << "Hello world!" << endl;
    int m,n,s;
    cin>>m>>n>>s;
    for(int i=m;i>=1;i--){
        int t=s%10;
        s=s/10;
        a[i]=t;

    }

    //cout<<getNum(1,2)<<endl;
    //cout<<getNum(3,2)<<endl;
    cout<<maxProduct(m,n)<<endl;
    cout<<minSum(m,n)<<endl;


    int fa[1000];
    int i = m;
	int k = m + 1;
    for (int j = n; j >= 1; j--) {
		fa[j] = getNum(fs[i][j], k - fs[i][j]);
		k = fs[i][j]; //记录上次的断点
		i = fs[i][j] - 1; //新的i值要减1
	}

	for (int i = 1; i <= n; i++) {
		cout << fa[i];
		if (i != n)
			cout << "*";
		else
            cout << "=";
	}


    return 0;
}


int getNum(int s,int len){
    int sum=0;
    for(int i=s;i<s+len;i++){
        sum=sum*10+a[i];
    }
    return sum;
}

int maxProduct(int m,int n){

    int f[m][n]={{0}};
    int fs[m][n]={{0}};

    for(int i=1;i<=m;i++){
        f[i][1]=getNum(1,i);
    }

    for(int i=1;i<=m;i++){
        for(int j=2;j<=n;j++){
            int Max=0;
            for(int k=j-1;k<=i-1;k++){
               int t=f[k][j-1]*getNum(k+1,i-k);
                if(Max<t){
                    Max=t;
                    fs[i][j] = k + 1;
                }
            }
            f[i][j]=Max;
            //cout<<i<<" "<<j<<endl;
        }
    }

    return f[m][n];
}


int minSum(int m,int n){

    int f[m][n]={{0}};
    int fs[m][n]={{0}};

    for(int i=1;i<=m;i++){
        f[i][1]=getNum(1,i);
    }

    for(int i=1;i<=m;i++){
        for(int j=2;j<=n;j++){
            int Min=99999;
            for(int k=j-1;k<=i-1;k++){
               int t=f[k][j-1]+getNum(k+1,i-k);
                if(Min>t){
                    Min=t;
                    //if(j==n)cout<<k<<endl;
                    fs[i][j]=k+1;
                }
            }
            f[i][j]=Min;
            //cout<<Max<<endl;
        }
    }


    int fa[1000];
    int i=m;
    int k=m+1;
    for(int j=n;j>=0;j--){
        fa[j]=getNum(fs[i][j],k-fs[i][j]);
        k=fs[i][j];
        i=fs[i][j]-1;
    }

    for (int i = 1; i <= n; i++) {
		cout << fa[i];
		if (i == n)
			cout << "=";
		else
            cout << "+";

	}



    return f[m][n];

}


 */

public class T_11090_H {
}
