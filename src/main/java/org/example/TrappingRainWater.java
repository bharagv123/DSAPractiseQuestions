package org.example;


public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(arr);
    }

    private static void trap(int[] arr) {
        int n = arr.length;
        int water = 0;
        int left=0;
        int right=n-1;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right) {
            if(arr[left] <= arr[right]) {
                if(leftMax < arr[left]) {
                    leftMax = arr[left];
                } else {
                    water += leftMax - arr[left];
                }
                left++;
            } else {
                if (rightMax <= arr[right]) {
                    rightMax = arr[right];
                } else {
                    water += rightMax - arr[right];
                }
                right--;
            }
        }
        System.out.println(water);
    }
}
