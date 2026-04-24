package org.example;

public class NthMagicalNumber {

    public static void main(String[] args) {
        int a = 12,b=18;
        int n = 23;
        findNthMagicalNumber(a, b, n);
    }
    public static int GCDofTwoNumbers(int a,int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int lcm(int a, int b) {
        return (a * b) / GCDofTwoNumbers(a, b);
    }
    private static void findNthMagicalNumber(int a, int b, int n) {
        int maxNum = Math.max(a, b);
        int minNum = Math.min(a, b);
        int lcm = lcm(maxNum, minNum);
        int min = 1,max = maxNum *n;
        int res = -1;
        while (max >= min) {
            int mid = (max + min) /2;
            if (Count(a,b,lcm,mid) >= n) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println("Program started");
        System.out.println(res);
    }

    private static int Count(int a,int b, int lcm, int mid) {
        return (mid/a) + mid/b - mid/lcm;
    }
}
