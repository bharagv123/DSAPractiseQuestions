package org.example;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWithoutRepeatingChars {
    public static void main(String[] args) {
        String str = "abcabcbb";
        lengthOfLongestSubstring(str);
    }

    private static void lengthOfLongestSubstring(String str) {
        int n = str.length();
        Set<Character> st = new HashSet<>();
        int maxLen = 0;
        int start = 0;
        for (int i=0;i<n;i++) {
            char ch =  str.charAt(i);
            while (st.contains(ch)) {
                st.remove(ch);
                start++;
            }
            st.add(ch);
            maxLen = Math.max(i-start+1,maxLen);
        }
        System.out.println(maxLen);
    }
}
