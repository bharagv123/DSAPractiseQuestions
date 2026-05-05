package org.example;

import java.util.HashMap;
import java.util.PriorityQueue;

// no two same characters of the String should be side by side

public class ReorganiseString {
    public static void main(String[] args) {
        String str = "samosa";
        reorganizeString(str);
    }
    public static void reorganizeString(String str) {
        int n = str.length();
        HashMap<Character,Integer > mp = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            mp.put(ch ,mp.getOrDefault(ch,0)+1);
            if(mp.get(ch) > (n+1)/2){
                System.out.println("Cannot Form a String");
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> mp.get(b) - mp.get(a));
        pq.addAll(mp.keySet());
        StringBuilder res = new StringBuilder();
        while(pq.size() >= 2){
            char first = pq.poll();
            char second = pq.poll();
            res.append(first);
            res.append(second);
            mp.put(first,mp.get(first)-1);
            mp.put(second,mp.get(second)-1);
            if(mp.get(first) > 0) pq.offer(first);
            if(mp.get(second) > 0) pq.offer(second);
        }
        if(!pq.isEmpty()){
            res.append(pq.poll());
        }
        System.out.println(res.toString());
    }
}
