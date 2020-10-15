package com.example.demo.leetcode.top.part_4;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class T79 {

    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,i,j,0))return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board,String word,int i,int j,int k){
        if (k >= word.length()) return true;
        if(i>=board.length||j>=board[0].length|| i<0 || j<0 || board[i][j]=='/' || board[i][j] != word.charAt(k))return false;
        char t=board[i][j];
        board[i][j]='/';
        boolean flag = dfs(board,word,i+1,j,k+1)||dfs(board,word,i,j+1,k+1)||dfs(board,word,i-1,j,k+1)|| dfs(board,word,i,j-1,k+1);
        board[i][j]=t;
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word="ABCCED";
        System.out.println(exist(board,word));
    }
}
