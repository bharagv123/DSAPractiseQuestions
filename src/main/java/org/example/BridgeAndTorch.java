package org.example;

// There are four persons ABCD and they have to cross a bridge. Only 2 persons can cross a bridge at a time.
// You need to find the least time all the persons should take to cross the bridge.
// Each person takes different times to cross the bridge. a takes 1 min, b takes 7, c takes 10 and d takes 2.
// Also it is night and there is only 1 torch available.
// What is the least time taken so that all the 4 have crossed the bridge?

import java.util.Arrays;

public class BridgeAndTorch {
    public static void main(String[] args) {
        int[] times = {1,2,7,10};
        solution(times);
    }

    private static void solution(int[] times) {
        int n = times.length;
        int totTime=0;
        Arrays.sort(times);
        int i = n-1;
        while (i>=3){
            int option1 = 2*times[1] + times[0] + times[i];
            int option2 = times[i] + 2*times[0] + times[i-1];
            totTime += Math.min(option1, option2);
            i =i-2;
        }
        if (i==2){
            totTime += times[0] + times[1] + times[2];
        } else if (i==1) {
            totTime += times[1];
        } else if (i==0){
            totTime += times[0];
        }
        System.out.println("Minimum Time taken by the Persons to Cross Bridge : " +  totTime);
    }
}
