package org.example;

/*

Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book.
You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
All books must be allocated.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all
possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.
 */

import java.util.Arrays;

public class BookAllocationProblem {

    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;
        helper(books,students);
    }

    public static void helper(int[] books,int students) {
        int n = books.length;
        int minPages = 0;
        int maxPages = 0;
        for (int i=0;i<n;i++) {
            minPages = Math.min(minPages,books[i]);
            maxPages += books[i];
        }
        int minPossiblePages = 0;
        while (minPages <= maxPages) {
            int possiblePages = (minPages+maxPages)/2;
            if(isAllocationPossible(possiblePages,books,students,n)) {
                minPossiblePages = possiblePages;
                maxPages = possiblePages-1;
            } else {
                minPages = minPages+1;
            }
        }
        System.out.println(minPossiblePages);
    }

    private static boolean isAllocationPossible(int possiblePages,int[] books,int students,int n) {
        int stud = 1;
        int currPages=0;
        for(int i=0;i<n;i++) {
            if(currPages + books[i] > possiblePages ) {
                stud++;
                currPages = books[i];
            } else {
                currPages += books[i];
            }
            if (stud>students){
                return false;
            }
        }
        return true;
    }
}
