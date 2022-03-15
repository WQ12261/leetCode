package page.leetcode.three;

import java.util.*;

public class OneHundredAndTwentyEight {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Map<String, Integer>> rightMap = new HashMap<>();
        Map<Integer, Map<String, Integer>> leftMap = new HashMap<>();
        int max = 0;
        for (int i : nums) {
            if (!set.add(i)) {
                continue;
            }
            Map<String, Integer> right = rightMap.get(i);
            Map<String, Integer> left = leftMap.get(i);
            Integer len = null;
            if (right != null && left != null) {
                Integer rightLen = right.get("len");
                Integer leftLen = left.get("len");
                len = rightLen + leftLen + 1;
                left.put("len", len);

                Integer leftIndex = right.get("left");
                Integer rightIndex = left.get("right");
                left.put("left", leftIndex);
                rightMap.put(rightIndex, left);
                leftMap.put(leftIndex, left);
            } else if (left == null && right == null) {
                Map<String, Integer> map = new HashMap<>();
                len = 1;
                map.put("len", 1);
                map.put("right", i + 1);
                map.put("left", i - 1);
                rightMap.put(i + 1, map);
                leftMap.put(i - 1, map);
            } else if (left != null) {
                len = left.get("len") + 1;
                left.put("len", len);
                left.put("left", i - 1);
                leftMap.put(i - 1, left);
            } else {
                len = right.get("len") + 1;
                right.put("len", len);
                right.put("right", i + 1);
                rightMap.put(i + 1, right);
            }
            rightMap.remove(i);
            leftMap.remove(i);
            max = Math.max(len, max);
        }
        return max;
    }

    public static int fastMethod(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int maxCount = 1;
        for (int i : nums) {
            if (set.contains(i - 1)) {
                continue;
            }
            int count = 1;
            int search = i + 1;
            while (set.contains(search)) {
                count++;
                search++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int s = 1;
        int count = 0;
        for (int i = 1;i<= 25;i++){
            if ( i == 7 || i== 9 || i== 11 || i== 17 || i == 19 || i == 14 || i == 13 || i== 6 || i == 18 || i == 3 || i == 21 || i == 23){
                continue;
            }
            s *= i;
            System.out.println(s);
            while (s % 10 == 0){
                count ++;
                s/=10;
            }
        }
        System.out.println(s);
        System.out.println(count);
    }
}
