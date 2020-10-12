package com.example.demo.leetcode.top.part_4;

import java.util.ArrayList;
import java.util.List;

public class T54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int xlen, ylen;
        if ((xlen = matrix.length) == 0) return list;
        ylen = matrix[0].length;
        int left = 0, top = 0, right = ylen - 1, bottom = xlen - 1;
        while (true) {
            for (int i = left; i <= right; i ++) list.add(matrix[top][i]);
            if (++ top > bottom) break;
            for (int i = top; i <= bottom; i ++) list.add(matrix[i][right]);
            if (-- right < left) break;
            for (int i = right; i >= left; i --) list.add(matrix[bottom][i]);
            if (-- bottom < top) break;
            for (int i = bottom; i >= top; i --) list.add(matrix[i][left]);
            if (++ left > right) break;
        }
        return list;
    }

}
