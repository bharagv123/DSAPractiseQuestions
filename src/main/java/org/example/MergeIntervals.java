package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals={{1,3}, {2,6}, {8,10}, {15,18}};
        solution(intervals);
    }
    private static void solution(int[][] intervals){
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0])); //sort intervals based on start
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        int start=intervals[0][0]; //start of first interval
        int end=intervals[0][1]; //end of first interval
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=end){ //overlap condition
                end=Math.max(end,intervals[i][1]); //extend the end
            }else{
                list.add(new int[]{start,end}); //add merged interval
                start=intervals[i][0]; //update start
                end=intervals[i][1]; //update end
            }
        }
        list.add(new int[]{start,end}); //add last interval
        int[][] result=list.toArray(new int[list.size()][]);
        for (int[] ints : result) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
