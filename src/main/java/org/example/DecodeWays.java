package org.example;

// A ->1 B -> 2 ... ...  -> 25 , Z -> 26
// 11106 -> "AAJF" with the grouping (1, 1, 10, 6) , "KJF" with the grouping (11, 10, 6)
//no of Ways

public class DecodeWays {
    public static void main(String[] args) {
        String str = "11106";
        int n = str.length();
        int res = solution(0,str);
        System.out.println("No of Ways to Decode the String: " + res);
    }

    private static int solution(int i,String str) {
        if(i==str.length()) return 1;
        if (str.charAt(i) == '0') return 0;
        int count=0;
        count+=solution(i+1,str);
        if(i < str.length() - 1){
            int num = Integer.parseInt(str.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                count+=solution(i + 2, str);
            }
        }
        return count;
    }
}
