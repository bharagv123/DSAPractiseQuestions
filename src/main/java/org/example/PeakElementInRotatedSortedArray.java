package org.example;

public class PeakElementInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,12,0,1,2};
        int res = pivotElement(nums);
        System.out.println(nums[res]);
    }

    private static int pivotElement(int[] nums) {
        int n = nums.length;
        int low =0,high=n-1;
        while (low < high){
            int mid = (low+high)/2;
            if (mid<n-1 && nums[mid]>nums[mid+1])
                return mid;
            else if (mid>0 && nums[mid]<nums[mid-1])
                return mid-1;
            if(nums[mid] >= nums[low]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }
}
