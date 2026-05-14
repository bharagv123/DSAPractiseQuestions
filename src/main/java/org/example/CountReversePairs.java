package org.example;

import java.util.ArrayList;

public class CountReversePairs {
    public static void main(String[] args) {
        int[] arr = {1,4,3,1,2,5};
        int n = arr.length;
        countPairs(arr,n);
    }

    private static void countPairs(int[] arr, int n) {
        int answer = mergeArr(arr,0,n-1);
        System.out.println(answer);
    }

    private static int countNumberPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    private static int mergeArr(int[] arr,int low, int high) {
        int cnt=0;
        if(low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeArr(arr,low,mid);
        cnt += mergeArr(arr,mid+1,high);
        cnt += countNumberPairs(arr,low,mid,high);
        mergeSortedArr(arr,low,mid,high);
        return cnt;
    }

    private static void mergeSortedArr(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
