package com.kk.number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {

    public static void main(String[] args) {

        System.out.println(53 % 10);

        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = twoSum2(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints2));
    }


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int remainValue = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == remainValue) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainValue = target - nums[i];
            if (map.containsKey(remainValue)) {
                return new int[]{map.get(remainValue), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}