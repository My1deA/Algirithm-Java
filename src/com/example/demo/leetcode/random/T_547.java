package com.example.demo.leetcode.random;


// 547. 朋友圈 https://leetcode-cn.com/problems/friend-circles/solution/union-find-suan-fa-xiang-jie-by-labuladong/
/*班上有N名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B的朋友，B 是 C的朋友，那么我们可以认为 A 也是 C的朋友。所谓的朋友圈，是指所有
朋友的集合 给定一个N * N的矩阵M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知
的朋友圈总数。

示例 1:
        输入:
        [[1,1,0],
        [1,1,0],
        [0,0,1]]

        输出: 2

示例 2:

        输入:
        [[1,1,0],
        [1,1,1],
        [0,1,1]]
        输出: 1

        N 在[1,200]的范围内。
        对于所有学生，有M[i][i] = 1。
        如果有M[i][j] = 1，则有M[j][i] = 1。*/

public class T_547 {


    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}

