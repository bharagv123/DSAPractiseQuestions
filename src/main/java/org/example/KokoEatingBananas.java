package org.example;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] nums = {3,6,7,11,12};
        int hours = 4;
        solution(nums,hours);
    }

    private static void solution(int[] nums, int hours) {
        int high = Integer.MIN_VALUE,low=Integer.MAX_VALUE;
        for (int i: nums){
            high = Math.max(high,i);
            low = Math.min(low,i);
        }
        int answer=high;
        while (low <= high){
            int mid = (high+low)/2;
            int totalHours = 0;
            for(int pile : nums){
                totalHours += (pile + mid - 1) / mid;
            }
            if (totalHours <= hours){
                answer = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        System.out.println(answer);
    }
}
