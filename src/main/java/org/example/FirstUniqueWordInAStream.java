package org.example;

import java.util.*;

public class FirstUniqueWordInAStream {
    public static void main(String[] args) {
        String input = "the dog is angry but the cat is not angry";
        helper(input);
    }

    static void helper(String input) {
        String[] words = input.split(" ");
        Queue<String> queue = new LinkedList<>();
        HashMap<String,Integer> countMap = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            queue.add(word);
            while (!queue.isEmpty() && countMap.get(queue.peek())>1) {
                queue.poll();
            }
            if(!queue.isEmpty()) {
                res.add(queue.peek());
            } else {
                res.add("");
            }
        }
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
