package org.example;

public class InorderPredecessorAndSuccessorOfBST {

    static class Node
    {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    static class Result {
        Node pred;
        Node succ;

        Result(Node pred,Node succ) {
            this.pred = pred;
            this.succ = succ;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        root.left.left.left = new Node(10);
        root.left.left.right = new Node(25);
        root.right.right.left = new Node(75);
        root.right.right.right = new Node(90);

        Node predecessor = null;
        Node successor = null;
        int key  = 75;
        Result res = new Result(null, null);
        PredecessorAndSuccessor(root,key,res);
        System.out.println("Predecessor of the " + key + " is: " + res.pred.key);
        System.out.println("Successor of the " + key + " is: " + res.succ.key);
    }

    private static void PredecessorAndSuccessor(Node root, int key,Result res) {
        while (root!=null) {
            if (root.key < key) {
                res.pred = root;
                root = root.right;
            } else if (root.key > key) {
                res.succ = root;
                root = root.left;
            } else {
                if(root.left != null) {
                    Node temp = root.left;
                    while(temp.right != null) {
                        temp = temp.right;
                    }
                    res.pred = temp;
                }
                if(root.right != null) {
                    Node temp = root.right;
                    while(temp.left != null) {
                        temp = temp.left;
                    }
                    res.succ = temp;
                }
                break;
            }
        }
    }
}
