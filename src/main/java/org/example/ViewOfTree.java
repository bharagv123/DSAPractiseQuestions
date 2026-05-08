package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;


public class ViewOfTree {
    static class Node
    {
        int key;
        Node left = null, right = null;

        Node(int key) {
            this.key = key;
        }
    }

    static class Pair {
        Node first;
        int second;
        Pair(Node first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        printBottomView(root);
        System.out.println();
        printTopView(root);
    }

    private static void printTopView(Node root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0)); // horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node node = pair.first;
            int hd = pair.second;
            map.putIfAbsent(hd, node.key);
            if (node.left!=null) {
                q.add(new Pair(node.left,hd-1));
            }
            if (node.right!=null) {
                q.add(new Pair(node.right,hd+1));
            }
        }
        System.out.println("Top view of the Tree");
        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    private static void printBottomView(Node root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0)); // horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node node = pair.first;
            int hd = pair.second;
            map.put(hd, node.key);
            if (node.left!=null) {
                q.add(new Pair(node.left,hd-1));
            }
            if (node.right!=null) {
                q.add(new Pair(node.right,hd+1));
            }
        }
        System.out.println("Bottom view of the Tree");
        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }
}
