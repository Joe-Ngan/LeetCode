package edu.northeastern.leetcode;

import java.util.PriorityQueue;

public class leetcode407 {
    public static void main(String[] args) {
        int[][] heightMap = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        System.out.println(trapRainWater(heightMap));
    }

    private static int count = 0;
    public static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        for(int i = 0; i<m; i++){
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n-1, heightMap[i][n-1]});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        for(int j = 1; j<n-1; j++){
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m-1, j, heightMap[m-1][j]});
            visited[0][j] = true;
            visited[m-1][j] = true;
        }

        while(!pq.isEmpty()){
            int[] first =  pq.poll();
            int height = first[2];
            for(int[] dir : directions){
                int x = first[0]+dir[0];
                int y = first[1]+dir[1];
                if(x<1 || x>m-1 || y<1 || y>n-1)
                    continue;
                if(visited[x][y])
                    continue;
                if(heightMap[x][y] <= height) {
                    count += (height - heightMap[x][y]);
                }
                if(heightMap[x][y] <= height){
                    count += (height-heightMap[x][y]);
                }
                pq.offer(new int[]{x, y, Math.max(height, heightMap[x][y])});
                visited[x][y] = true;
            }
        }
        return count;
    }
}
