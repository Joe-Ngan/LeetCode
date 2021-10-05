package com.company.Homework2.Leetcode1;

import java.util.Arrays;

public class TransposeMatrix867 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(transpose(matrix)));

    }
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] ans = new int[n][m];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                ans[j][i]=matrix[i][j];
            }
        }
        return ans;
    }
}
