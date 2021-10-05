package com.company.Homework2.Leetcode4;

import java.util.Arrays;

public class RotateImage48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotate = new int[n][n];

        for(int i = 0; i< n; i++){
            for( int j = 0; j< n; j++){
                rotate[j][n-i-1] =  matrix[i][j];
            }
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j< n ; j++){
                matrix[i][j] = rotate[i][j];
            }
        }
    }
}
