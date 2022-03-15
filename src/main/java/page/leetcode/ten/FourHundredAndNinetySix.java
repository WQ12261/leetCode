package page.leetcode.ten;

import array.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourHundredAndNinetySix {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int pre = nums2[nums2.length - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(pre, -1);
        for (int i = nums2.length - 2; i >=0; i--) {
            if (pre > nums2[i]) {
                map.put(nums2[i], pre);
            } else {
                while (true){
                    Integer preMax = map.get(pre);
                    if (preMax.compareTo(-1)==0){
                        map.put(nums2[i],-1);
                        break;
                    }else if (preMax.compareTo(nums2[i])>0){
                        map.put(nums2[i],preMax);
                        break;
                    }else{
                        pre = preMax;
                    }
                }
            }
            pre = nums2[i];
        }
        int []array = new int[nums1.length];
        for (int i= 0;i<nums1.length;i++){
            array[i] = map.get(nums1[i]);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        nextGreaterElement(nums1, nums2);
    }

}
