package org.example;

public class MaximumArea {
    public static void main(String[] args) {
        int[] arr = {2,6,2,5,9,1,4,8,3};
        int n = arr.length;
        maxArea(arr,n);
    }

    private static void maxArea(int[] arr, int n) {
        int maxArea = 0;
        int left = 0,right=n-1;
        while (left < right) {
            int height = Math.min(arr[left],arr[right]);
            maxArea = Math.max(height*(right-left) ,maxArea);
            if(arr[left] > arr[right]) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(maxArea);
    }
}
