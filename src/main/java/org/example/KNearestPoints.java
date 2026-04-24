package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KNearestPoints {
    public static void main(String[] args) {
        int[][] points = {{1,3}, {-2,2}, {5,8}, {0,1},{2,3}};
        int k = 2;
        List<Integer> ans = new ArrayList<>();
        solution(points,k,ans);
    }

    private static void solution(int[][] points, int k, List<Integer> ans) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a,b) -> {
            return ((b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        });
        int n = points.length;
        for (int[] point : points){
            pq.offer(point);
            if (pq.size()>k){
                pq.poll();
            }
        }
        System.out.println("K Nearest Points are :");
        while (!pq.isEmpty()){
            int[] point = pq.poll();
            int distance = point[0]*point[0]+point[1]*point[1];
            System.out.println(point[0]+ ":" + point[1] + " Distance is: "+ distance);
        }
    }
}
