package org.example;

//Input:  words[] = ["baa", "abcd", "abca", "cab", "cad"]
//Output: "bdac"
//Input:  words[] = ["caa", "aaa", "aab"]
//Output: "cab"

import java.util.*;

public class AlienDictonaryLexoGrapicalOrder {
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        String res = findOrder(words);
        System.out.println("Alien Dictionary Lexicographical Order Is: " + res);
    }

    private static String findOrder(String[] words) {
        Map<Character, Set<Character>> graph =  new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();

        //initialize
        for(String word : words){
            for(char ch : word.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }
        //creating Graph
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());

            for(int k=0;k<minLen;k++){
                char ch1 = w1.charAt(k);
                char ch2 = w2.charAt(k);

                if (ch1!=ch2) {
                    if(!graph.get(ch1).contains(ch2)){
                        graph.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2)+1);
                        break;
                    }
                }
            }
        }
        //offering the lowest inorder to Queue
        Queue<Character> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for(char ch : indegree.keySet()){
            if (indegree.get(ch)==0) {
                q.offer(ch);
            }
        }
        //finding The order
        while(!q.isEmpty()){
            char cur = q.poll();
            res.append(cur);
            for(char neighbour : graph.get(cur)){
                indegree.put(neighbour, indegree.get(neighbour)-1);
                if(indegree.get(neighbour)==0){
                    q.offer(neighbour);
                }
            }
        }
        if(res.length()!=indegree.size()){
            return "Invalid";
        } else
            return res.toString();
    }
}
