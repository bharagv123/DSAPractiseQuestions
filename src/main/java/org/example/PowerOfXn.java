package org.example;

public class PowerOfXn {
    public static void main(String[] args) {
        int number = 3;
        int power = 3;
        powerofTwoNumbers(number,power);
    }

    private static void powerofTwoNumbers(int number, int exponent) {
        int base=number;
        int res=1;
        while (exponent > 0){
            if ((exponent&1)==1){
                res = res*base;
            }
            base=base*base;
            exponent = exponent >>1;
        }
        System.out.println(res);
    }
}
