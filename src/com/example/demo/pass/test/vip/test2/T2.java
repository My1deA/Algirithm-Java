package com.example.demo.pass.test.vip.test2;


/*数独是一个非常有名的游戏。整个是一个9X9的大宫格，其中又被划分成9个3X3的小宫格。要求在每个小格中放入1-9中的某个数字。要求是：每行、每列、每个小宫格中数字不能重复。 现要求用计算机求解数独。（50分）

        输入描述:
        输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的数字。

        输出描述:
        输出九行，每行九个空格隔开的数字，为解出的答案。

        输入例子1:                     输出例子1:
        0 9 0 0 0 0 0 6 0               7 9 3 8 5 1 4 6 2
        8 0 1 0 0 0 5 0 9               8 4 1 2 6 7 5 3 9
        0 5 0 3 0 4 0 7 0               6 5 2 3 9 4 1 7 8
        0 0 8 0 7 0 9 0 0               3 2 8 4 7 6 9 5 1
        0 0 0 9 0 8 0 0 0               5 7 4 9 1 8 6 2 3
        0 0 6 0 2 0 7 0 0               9 1 6 5 2 3 7 8 4
        0 8 0 7 0 5 0 4 0               1 8 9 7 3 5 2 4 6
        2 0 5 0 0 0 8 0 7               2 3 5 6 4 9 8 1 7
        0 6 0 0 0 0 0 9 0               4 6 7 1 8 2 3 9 5

*/
class T2 {
    public void solveSudoku(char[][] board) {
        /**
         * 记录某行，某位数字是否已经被摆放
         */
        boolean[][] row = new boolean[9][9];
        /**
         * 记录某列，某位数字是否已经被摆放
         */
        boolean[][] col = new boolean[9][9];
        /**
         * 记录某 3x3 宫格内，某位数字是否已经被摆放
         */
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    // blockIndex = i / 3 * 3 + j / 3，取整
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        // 找寻空位置
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        for (int num = 0; num < 9; num++) {
            int blockIndex = i / 3 * 3 + j / 3;
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                // 递归
                board[i][j] = (char) ('1' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if (dfs(board, row, col, block, i, j)) {
                    return true;
                } else {
                    // 回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        T2 solution = new T2();
        solution.printBoard(board);
        solution.solveSudoku(board);
        solution.printBoard(board);
    }
}
