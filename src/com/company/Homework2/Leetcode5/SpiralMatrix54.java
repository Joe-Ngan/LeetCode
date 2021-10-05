package com.company.Homework2.Leetcode5;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
    private static List<Integer> list = new ArrayList();
    public static List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        goR(0,0,n-1,m-1, matrix);
        return list;
    }

    public static void goR(int l, int u, int r, int d, int[][] matrix){
        if(d>=u && r>=l){
            int index = l;
            while(l<=r){
                list.add(matrix[u][l++]);
            }
            goD(index,u+1,r,d, matrix);
        }
    }

    public static void goD(int l, int u, int r, int d, int[][] matrix){
        if(d>=u && r>=l){
            int index = u;
            while(u<=d){
                list.add(matrix[u++][r]);
            }
            goL(l,index,r-1,d, matrix);
        }
    }

    public static void goL(int l, int u, int r, int d, int[][] matrix){
        if(d>=u && r>=l){
            int index = r;
            while(r>=l){
                list.add(matrix[d][r--]);
            }
            goU(l,u,index,d-1, matrix);
        }
    }

    public static void goU(int l, int u, int r, int d, int[][] matrix){
        if(d>=u && r>=l){
            int index = d;
            while(d>=u){
                list.add(matrix[d--][l]);
            }
            goR(l+1, u, r, index, matrix);
        }
    }
}
