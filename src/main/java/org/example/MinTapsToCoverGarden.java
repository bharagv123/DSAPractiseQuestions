package org.example;

public class MinTapsToCoverGarden {
    public static void main(String[] args) {
        int[] ranges = {3,4,1,1,0,0};
        int n = ranges.length-1; // Garden length is ranges.length - 1
        minTaps(n,ranges);
    }

    public static void minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n+1];
        for (int i = 0; i <= n; i++) {   // Convert each tap into an interval
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            maxReach[left] = Math.max(maxReach[left], right);
        }

        int taps = 0;
        int currEnd = 0;
        int farthest = 0;
        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, maxReach[i]);
            if (i == farthest) {       // Cannot move forward
                System.out.println(-1);
            }
            if (i == currEnd) {    // Cannot move forward
                taps++;
                currEnd = farthest;
            }
        }
        System.out.println(taps);
    }
}
