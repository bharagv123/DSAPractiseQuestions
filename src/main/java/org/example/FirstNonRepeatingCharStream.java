package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharStream {
    public static void NonRepeatingCharacterStream(String str) {
        int n = str.length();
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        Queue<Character>  queue = new LinkedList<>();
        for(int i=0;i<n;i++) {
            char ch = str.charAt(i);
            freq[ch-'a']++;
            queue.add(ch);
            while(!queue.isEmpty() && freq[queue.peek()-'a'] > 1){
                queue.poll();
            }
            if(queue.isEmpty()) {
                sb.append("-1");
            } else {
                sb.append(queue.peek());
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        String str = "aabcdbascesd";
        NonRepeatingCharacterStream(str);
    }
}
