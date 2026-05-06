package org.example;

// given a list of elements sort the array

public class SortAnArray {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1,5,2,6,3,8,1};
        int n = arr.length;
        mergeSort(arr,0,n-1);
        for (int ele : arr){
            System.out.print(ele + " ");
        }
    }

    private static void mergeSort(int[] arr,int low,int high) {
        if(low >= high) return;
        int mid = low + (high-low)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr, int low, int mid,int high) {
        int m = high-low+1;
        int[] temp = new int[m];
        int left = low;
        int right = mid+1;
        int k=0;
        while(left<=mid && right<=high) {
            if(arr[left] < arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        while(left<=mid) {
            temp[k++] = arr[left++];
        }
        while (right<=high) {
            temp[k++] = arr[right++];
        }
        for(int i=0;i<temp.length;i++){
            arr[low + i] = temp[i];
        }
    }
}
