package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindSmallestKPairs {
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 4;
        kSmallestPairs(nums1,nums2,k);
    }

    private static void kSmallestPairs(int[] nums1, int[] nums2,int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
             return nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]);
        });
        for(int i=0;i<n1 && i<k;i++) {
            pq.offer(new int[]{i,0});
        }
        List<int[]> result = new ArrayList<>();

        while (k-- > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            int i = current[0];
            int j = current[1];
            result.add(new int[]{nums1[i],nums2[j]});
            if(j+1<n2) pq.offer(new int[]{i,j+1});
        }
        for (int i=0;i<result.size();i++) {
            int i1 = result.get(i)[0];
            int i2 = result.get(i)[1];
            System.out.println("numbers are : " + i1 + " " + i2);
        }
    }
}
