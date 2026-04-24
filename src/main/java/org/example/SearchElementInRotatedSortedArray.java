package org.example;

public class SearchElementInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low=0,high=n-1;
        while (low <= high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid] > nums[low]){ //left is sorted
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {  //right is sorted
                if (target <= nums[high] && target > nums[mid]){
                    low=mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 12;
        int res = search(nums,target);
        System.out.println(res);
    }
}
