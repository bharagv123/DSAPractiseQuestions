package org.example;

import java.util.*;

public class MinTimeToExecAllProcess {
    public static void main(String[] args) {
        int n = 4;
        int[] time = {2, 3, 1, 2};
        int[][] dependencies = {{0,1}, {2,3}};
        helper(n,time,dependencies);
    }

    private static void helper(int n, int[] time, int[][] dependencies) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        Arrays.fill(indegree,0);
        for (int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] dep : dependencies) {
            int x = dep[0];
            int y = dep[1];
            graph.get(x).add(y);
            indegree[y]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] finTime = new int[n];
        for(int i=0;i<n;i++) {
            if (indegree[i]==0) {
                queue.add(i);
                finTime[i] = time[i];
            }
        }
        int comProcess = 0,minTotalTime = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            comProcess++;
            minTotalTime = Math.max(minTotalTime,finTime[curr]);
            for (int next : graph.get(curr)) {
                finTime[next] = Math.max(finTime[next],finTime[curr]+time[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (comProcess != n) {
            System.out.println("Not Possible");
        } else {
            System.out.println(minTotalTime);
        }
    }
}
