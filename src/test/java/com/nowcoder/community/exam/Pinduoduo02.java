package com.nowcoder.community.exam;

import java.util.Scanner;

public class Pinduoduo02 {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=in.nextInt();
            }
        }

        int[] map = new int[grid.length*grid[0].length/2+3];
        int index = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fullIsland(grid, i, j, index++);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    map[grid[i][j]]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int t = 1,t1=0,t2=0,t3=0,t4=0;
                    if (i > 0 && (t1 = grid[i - 1][j]) > 1) {
                        t += map[t1];
                    }
                    if (i < grid.length - 1 && (t2 = grid[i + 1][j]) > 1 && t2 !=t1) {
                        t += map[t2];
                    }
                    if (j > 0 && (t3 = grid[i][j - 1]) > 1 && t2 !=t3 && t1 !=t3) {
                        t += map[t3];
                    }
                    if (j < grid[0].length - 1 && (t4 = grid[i][j + 1]) > 1 && t4 != t3 && t2 != t4 && t1 != t4) {
                        t += map[t4];
                    }
                    max = Math.max(max, t);
                }
            }
        }
        if (max == 0) {
            if (grid[0][0] == 0) {
                System.out.println(1);
            } else {
                System.out.println(grid.length*grid[0].length);
            }
        }
        System.out.println(max);;
    }

    public static void fullIsland(int[][] grid, int i, int j, int index) {
        grid[i][j] = index;
        if (i > 0 && grid[i - 1][j] == 1) {
            fullIsland(grid, i - 1, j, index);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            fullIsland(grid, i + 1, j, index);
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            fullIsland(grid, i, j - 1, index);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            fullIsland(grid, i, j + 1, index);
        }
    }
}
