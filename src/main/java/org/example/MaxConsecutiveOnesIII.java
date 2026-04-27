package org.example;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int res = longestOnes(nums,k);
        System.out.println(res);
    }

    private static int longestOnes(int[] nums, int k) {
        int low=0,high=0;
        int n = nums.length;
        int maxLength = 0;
        while (high < n) {
            if (nums[high] == 0){
                k--;
            }
            while (k<0){
                if (nums[low] == 0){
                    k++;
                }
                low++;
            }
            maxLength = Math.max(maxLength, high-low+1);
            high++;
        }
        return maxLength;
    }
}
