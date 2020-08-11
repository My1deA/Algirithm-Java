package com.example.demo.test.vip.test2;


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
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                rows[i][board[i][j] - '1'] = true;
                cols[j][board[i][j] - '1'] = true;
                boxes[(i / 3) * 3 + j / 3][board[i][j] - '1'] = true;
            }
        }

        boolean b = solve(board, 0);

    }

    public boolean solve(char[][] board, int index) {
        if (index == 81) return true;

        int r = index / 9;
        int c = index % 9;
        int b = (r / 3) * 3 + c / 3;

        if (board[r][c] != '.') {
            return solve(board, index + 1);
        } else {
            for (int i = 0; i < 9; i++) {
                if (!rows[r][i] && !cols[c][i] && !boxes[b][i]) {
                    board[r][c] = (char) (i + '1');
                    rows[r][i] = true;
                    cols[c][i] = true;
                    boxes[b][i] = true;
                    if (solve(board, index + 1)) return true;
                    rows[r][i] = false;
                    cols[c][i] = false;
                    boxes[b][i] = false;
                    board[r][c] = '.';
                }
            }
        }
        return false;
    }
}
