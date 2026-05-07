package org.example;

//Given an integer N and a 2D array cost[][3], where cost[i][0], cost[i][1], and cost[i][2]
// is the cost of painting ith house with colors red, blue, and green respectively,
// the task is to find the minimum cost to paint all the houses such that no two adjacent houses have the same color.

import java.util.Arrays;

public class MinimizeCostOfPainting {
    public static void main(String[] args) {
        int N = 3;
        int cost[][] = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        int[][] dp = new int[N][4];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int answer = minimizeCost(0,cost,N,-1,dp);
        System.out.println(answer);
    }

    private static int minimizeCost(int i, int[][] cost,int n,int choice, int[][] dp) {
        if (i==n-1) {
            int minCost = Integer.MAX_VALUE;
            for (int j=0;j<3;j++){
                if (choice!=j) {
                    minCost =  Math.min(cost[i][j],minCost);
                }
            }
            return minCost;
        }
        if (dp[i][choice+1]!=-1) return dp[i][choice+1];
        int minCost = Integer.MAX_VALUE;
        for (int j=0;j<3;j++) {
            if(j!=choice) {
                minCost = Math.min(cost[i][j] + minimizeCost(i+1,cost,n,j,dp),minCost);
            }
        }
        return dp[i][choice+1] = minCost;
    }

}
