package org.example;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String str = ")()())";
        solution(str);
    }

    private static void solution(String str) {
        int maxLen = 0;
        int n = str.length();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0;i<str.length();i++){
            if (str.charAt(i)=='('){
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()){
                    st.push(i);
                } else {
                    int len = i-st.peek();
                    maxLen = Math.max(len,maxLen);
                }
            }
        }
        System.out.println("The length of Largest Valid parenthesis is: " + maxLen);
    }
}
