package org.example;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,5,1,1,1,1};
        int k = 3;
        int res = subarraySum(nums,k);
        System.out.println(res);
    }

    private static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : nums){
            sum += num;
            if (map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
