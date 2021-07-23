package com.example.demo.pass.algorithm.track;


// 11089 多机最佳调度 回溯+贪心
/*Description
        假设有n个任务（n<=100），m台机器（m<=50），任务可以由任何一个机器完成，完成任务i需要的时间为ti，
        请设计两种算法（一种采用贪心算法，另一种采用回溯算法），找出完成这n个任务的最佳调度，使得最早时间完成全部任务。

        这里采用两种算法来求解：
        1）贪心算法可以得到近似的最早完成时间，算法思想在书上4.7节。
        2）回溯算法搜索m叉树（除叶节点外每个节点m个儿子），寻找最早的完成时间。

        输入格式
        输入两行，第一行为n和m，中间空格相连（其中n表示任务的数量，m表示机器的数量），（n<=100, m<=50）。
        第二行的n个数是任务i的处理时间ti。

        输出格式
        输出两行，第一行为采用贪心算法算出的最早完成时间，第二行为采用回溯算法搜索出的最早完成时间。



        输入样例                                      输入样例
        7 3                                           17
        2 14 4 16 6 5 3                               17

        另一个输入示例：                               另一个输出示例：
        14 3                                          37
        10 10 10 10 10 7 7 7 7 7 5 5 5 5              35

        提示
        第（1）个贪心算法按书上思想去实现。
        第（2）个就是在m叉树上深度优先搜寻最优解的过程。
        //t数组为初始的任务处理时间；
        //len2数组为第二种回溯算法在搜索过程中已探察过任务的完成时间和；
        //x数组用来保存探察过的任务编号。
        void backtrack (int dep)
        {
            if (dep == n) //叶子，或者if (dep>n)，看首次调用backtrack参数是0还是1
            {
                 ……
                return;
             }
        for(int i = 0; i < m; i++)
        {
            len2[i] += t[dep];
            x[dep] = i+1;
            if(len2[i] < best)
            {
                backtrack(dep+1);
            }
            len2[i] -= t[dep];
        }
        }*/
public class T_11089 {

    private static int n=7;
    private static int m=3;
    private static int best=Integer.MAX_VALUE;

    // 贪心算法 都要sort
    public static int greedy(int[] a,int n,int m){
        sort(a);
        int[] machine=new int[m];
        for(int i=0;i<n;i++){
            int index=0;
            int min=machine[index];
            for(int j=0;j<m;j++){
                if(min>machine[j]){
                    min=machine[j];
                    index=j;
                }
            }
            machine[index]+=a[i];
        }
        int max=machine[0];
        for(int i=1;i<m;i++){
            if(max<machine[i]){
                max=machine[i];
            }
        }
        return max;
    }

    public static void backTrack(int[] a,int[] mc,int[] rc,int cur){
        if(cur>=n){
            int max=mc[0];
            for(int i=1;i<m;i++){
                if(max<mc[i]){
                    max=mc[i];
                }
            }
            if(max<best){
                best=max;
            }
            return;
        }
        for(int i=0;i<m;i++){
            //机器i 添加对应的 工作时间
            mc[i] += a[cur];
            rc[cur] = i;//记录目前 哪个任务在那台机器上
            if(rc[i] < best)
            {
                backTrack(a,mc,rc,cur+1);
            }
            mc[i] -= a[cur];
        }
    }


    //先拍下
    public static void sort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]<a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;

    }

    public static void main(String[] args) {
        n=7;
        m=3;
        int[] a={2,14,4,16,6,5,3};
        int[] b={2,14,4,16,6,5,3};
        int[] x=new int[7];
        int[] rc=new int[7];
        System.out.println(greedy(a,n,m));
        backTrack(b,x,rc,0);
        System.out.println(best);
    }
}
