package org.example;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5,7,9,12};
        int amount = 56;
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = minCoins(0,amount,coins,n,dp);
        if(ans >= Integer.MAX_VALUE - 1) {
            System.out.println("-1");
        }
        System.out.println("Minimum Coins Required is : " + ans);
    }

    public static int minCoins(int i, int amount, int[] coins,int n,int[][] dp) {
        if(amount==0) {
            return 0;
        }
        if(i==n) return Integer.MAX_VALUE-1;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int pick=Integer.MAX_VALUE - 1;
        if (coins[i]<=amount){
            pick = 1 + minCoins(i,amount-coins[i],coins,n,dp);
        }
        int notPick = minCoins(i+1,amount,coins,n,dp);
        return dp[i][amount] = Math.min(pick,notPick);
    }
}
