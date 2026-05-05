package org.example;

import java.util.Stack;

//find greater element in a circular array

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,3};
        nextGreaterElementArray(arr);
    }

    private static void nextGreaterElementArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1; i>=0; i--) {
            int j = (i)%n;
            while(!st.isEmpty() && st.peek() <= arr[j]){
                st.pop();
            }
            if(i<=n-1) {
                if(st.isEmpty()){
                    res[i]=-1;
                } else {
                    res[i]=st.peek();
                }
            }
            st.push(arr[j]);
        }
        for (int i=0;i<n;i++) {
            System.out.println(res[i]);
        }
    }
}
