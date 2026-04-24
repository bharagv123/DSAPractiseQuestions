package org.example;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{2,3},{6,7}};
        //int[][] envelopes = {{1,1},{1,1},{1,1}};
        maxEnvelopes(envelopes);
    }

    private static void maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if (a[0]==b[0]) return -a[1]+b[1];
            return a[0]-b[0];
        });
        int n = envelopes.length;
        int[][] dp = new int[n][n+1];
        for (int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int result = solution(0,-1,envelopes,dp);
        System.out.println(result);
    }

    private static int solution(int i,int prev,int[][] envelopes,int[][] dp) {
        if (i == envelopes.length) return 0;
        if (dp[i][prev+1]!=-1) return dp[i][prev+1];
        int notTake = solution(i+1,prev,envelopes,dp);
        int take = 0;
        if (prev ==-1 || envelopes[prev][0]<envelopes[i][0] && envelopes[prev][1]<envelopes[i][1]){
            take = 1 + solution(i+1,i,envelopes,dp);
        }
        return dp[i][prev+1] = Math.max(notTake,take);
    }
}
