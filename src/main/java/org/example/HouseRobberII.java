package org.example;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] arr = {2,3,6,1,2,4,7,1};
        int n = arr.length;
        int res1 = robMaxiMum(arr,0,n-2);
        int res2 = robMaxiMum(arr,1,n-1);
        System.out.println(Math.max(res2,res1));
    }

    private static int robMaxiMum(int[] arr,int start, int end) {
        int length = end-start+1;
        int[] dp = new int[length];
        dp[0]=arr[start];
        dp[1]=Math.max(arr[start],arr[start+1]);
        for(int i=start+2;i<=end;i++){
            int idx = i-start;
            dp[idx] = Math.max(arr[i]+dp[idx-2],dp[idx-1]);
        }
        return dp[length-1];
    }
}
