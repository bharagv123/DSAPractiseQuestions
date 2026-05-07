package org.example;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "AABABBASSDFESSS";
        int k = 3;
        characterReplacement(str,k);
    }

    private static void characterReplacement(String str, int k) {
        int n = str.length();
        int start = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLen = 0;

        for (int end=0;end<n;end++) {
            char ch = str.charAt(end);
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq, freq[ch-'A']);
            while (end-start+1 - maxFreq > k) {
                freq[str.charAt(start)-'A']--;
                start++;
            }
            maxLen = Math.max(end-start+1,maxLen);
        }
        System.out.println(maxLen);
    }
}
