package com.example.demo.pass.leetcode.offer.more;


import java.util.LinkedList;

/* 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
因为3+5+3+8=19。请问该机器人能够到达多少个格子？

输入：m = 2, n = 3, k = 1
输出：3

输入：m = 3, n = 1, k = 0
输出：1

提示：1 <= n,m <= 100 0 <= k <= 20
 */
class Solution13_dfs {
    private int m;
    private int n;
    private int k;
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        this.k=k;
        this.visited=new boolean[m][n];
        return dfs(0,0,0,0);
    }

    public int dfs(int i,int j,int si,int sj){
        if(i>=m || j>=n || k<(si+sj) || visited[i][j] )return 0;
        visited[i][j]=true;
        return 1 + dfs(i+1,j,((i+1)%10 == 0? si-8:si+1),sj) + dfs(i,j+1,si,((j+1)%10 ==0 ? sj-8:sj+1)) ;
    }
}

class Solution13_bfs {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        int res=0;
        LinkedList<int []> deque=new LinkedList<>();
        deque.add(new int[]{0,0,0,0});
        visited[0][0]=true;
        while(deque.isEmpty()){
            int[] t=deque.poll();
            int i=t[0],j=t[1],si=t[2],sj=t[3];
            if(i>=m || j>=n || k<(si+sj) || visited[i][j]) continue;
            deque.offer(new int[]{i+1,j,(i+1)%10==0?si-8:si+1,sj});
            deque.offer(new int[]{i,j+1,si,(j+1)%10==0?sj-8:sj+1,});
            res++;
        }
        return 0;
    }


}

public class Title13 {
    public static void main(String[] args) {
        Solution13_dfs solution = new Solution13_dfs();
        System.out.println(solution.movingCount(3,8,15));
    }
}
