package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int noOfCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        OrderOfTheCompletion(noOfCourses, prerequisites);
    }

    private static void OrderOfTheCompletion(int noOfCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(noOfCourses);
        for (int i=0;i<noOfCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[noOfCourses];
        for (int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.get(b).add(a);
            inDegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<noOfCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int countCourses = 0;
        ArrayList<Integer> orderOfCourse = new ArrayList<>();
        while (!q.isEmpty()){
            int course = q.poll();
            orderOfCourse.add(course);
            countCourses++;
            for (int neightbour : graph.get(course)){
                inDegree[neightbour]--;
                if (inDegree[neightbour]==0){
                    q.add(neightbour);
                }
            }
        }
        if (countCourses == noOfCourses){
            System.out.println("Completion Of all Courses Possible");
            for (int i=0;i<orderOfCourse.size();i++){
                System.out.print(orderOfCourse.get(i) + " -> ");
            }
        } else {
            System.out.println("Completion Of all Courses Not Possible");
        }

    }
}
