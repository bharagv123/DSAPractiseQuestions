/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour,
she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
she eats all of them instead and won't eat any more that hour.
Koko likes to eat slowly but still wants to eat all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
*/
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
