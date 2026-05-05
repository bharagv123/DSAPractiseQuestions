package org.example;

public class MaximumRunningTimeOfNComputers {
    public static void main(String[] args) {
        int n = 3;
        int[] batteries = {13,4,2};
        maxRunTime(n,batteries);
    }

    private static void maxRunTime(int n, int[] batteries) {
        int noOfBatteries = batteries.length;
        int low = 0;
        int total =0;
        for(int i=0;i<noOfBatteries;i++){
            total += batteries[i];
        }
        int high = total/n;
        int resTime = 0;
        while(low <= high) {
            int possibleTime = (low+high)/2;
            if(isPossible(possibleTime,batteries,n)){
                resTime = possibleTime;
                low = possibleTime +1;
            } else {
                high = possibleTime-1;
            }
        }
        System.out.println("maxPossible Time is : " + resTime);
    }

    private static boolean isPossible(int possibleTime, int[] batteries, int n) {
        int total =0;
        for (int battery : batteries) {
            total += Math.min(battery, possibleTime);
        }
        return total >= n*possibleTime;
    }

}
