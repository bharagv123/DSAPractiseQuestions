package org.example;

import java.util.Arrays;

public class CarFleet {
    public static void main(String[] args) {
        int taget = 12;
        int[] positons = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        solution(taget,positons,speed);
    }

    private static void solution(int target, int[] positions, int[] speed) {
        int n = positions.length;
        double[][] time = new double[n][2];
        for (int i=0;i<n;i++){
            time[i][0] = (double) (target - positions[i]) /speed[i];
            time[i][1]=positions[i];
        }
        Arrays.sort(time,(a,b)-> Double.compare(b[1],a[1]));
        int fleets=0;
        double prevTime =0;
        for (int i=0;i<n;i++){
            double currTime = time[i][0];
            if (currTime > prevTime){
                fleets++;
                prevTime = currTime;
            }
        }
        System.out.println(fleets);
    }
}
