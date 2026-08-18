package org.example;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maximumNumberWindow(arr,k);
    }

    private static void maximumNumberWindow(int[] arr,int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (i > k-1) {
                res.add(arr[dq.peekFirst()]);
            }
        }
        System.out.println(res);
    }
}
