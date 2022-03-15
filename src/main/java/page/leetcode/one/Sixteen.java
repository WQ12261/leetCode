package page.leetcode.one;

import page.leetcode.two.Sixty;

import java.util.*;

public class Sixteen {
    public int threeSumClosest(int[] nums, int target) {
        Map<String,Integer> map=new HashMap<>();
        combine(nums, 0, nums.length-1, 0, 3, target, 0, map);
        return map.get("nearestNumber");
    }
    private void combine(int[] nums, int start, int end, int count,int totalCount, int target,int sum,Map<String,Integer> map){
        if (count==totalCount){
            Integer nearestNumber = map.get("nearestNumber");
            if (nearestNumber != null) {
                int curr = Math.abs(sum - target);
                int pre = Math.abs(nearestNumber - target);
                nearestNumber = pre > curr ? sum : nearestNumber;
            }else {
                nearestNumber=sum;
            }
            map.put("nearestNumber", nearestNumber);
            return;
        }
        if (start>end){
            return;
        }
        for (int i=start;i<=end;i++){
            swap(i, start, nums);
            sum+=nums[start];
            combine(nums, i+1, end, count+1, totalCount,target, sum  , map);
            sum-=nums[start];
            swap(i, start, nums);
        }
    }
    private void swap(int a,int b,int[] nums){
        int value=nums[a];
        nums[a]=nums[b];
        nums[b]=value;
    }
    public int methodTwo(int[] nums, int target){
        int nearestValue=nums[0]+nums[1]+nums[2];
        int curr=0;
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            while (i>0&&i<nums.length-2&&nums[i]==nums[i-1]){
                i++;
            }
            for (int j=nums.length-1;j>i+1;j--){
                while (j<nums.length-1&&j>i+1&&nums[j]==nums[j+1]){
                    j--;
                }
                if (j<=i+1){
                    break;
                }
                curr=nums[i]+nums[j];
                if (curr>=target){
                    nearestValue = forwardTraversal(i + 1, j - 1, 0, curr, nearestValue, target, nums);

                }else {
                    nearestValue=backwardTraversal(i+1, j-1, 0, curr, nearestValue, target, nums);
                }
                if (nearestValue==target){
                    return nearestValue;
                }
            }
        }
        return nearestValue;
    }
    private int forwardTraversal(int left,int right,int limitValue,int initialVal,int nearestValue,int target,int nums[]){
        int preValue=initialVal+nums[left];
        nearestValue=getNearestValue(nearestValue,preValue,target);

        for (int i=left+1;i<=right&&nums[i]<=limitValue;i++){
            while (nums[i]==nums[i-1]&&i<right){
                i++;
            }
            if (i>right||preValue>target){
                break;
            }
            preValue=initialVal+nums[i];
            if (preValue==target){
                System.out.println(i);
            }
            nearestValue=getNearestValue(nearestValue, preValue, target);
            if (nearestValue==target){
                break;
            }
        }
        return nearestValue;
    }
    private int backwardTraversal(int left,int right,int limitValue,int initialValue,int nearestValue,int target,int[] nums){
        int preValue=initialValue+nums[right];
        nearestValue=getNearestValue(nearestValue, preValue,target);
        for (int i=right-1;i>=left&&nums[i]>=limitValue;i--){
            while (nums[i]==nums[i+1]&&i>left){
                i--;
            }
            if (i<left&&preValue<target){
                break;
            }
            preValue=initialValue+nums[i];
            if (preValue==target){
                System.out.println(i);
            }
            nearestValue=getNearestValue(nearestValue, preValue, target);
            if (nearestValue==target){
                break;
            }
        }
        return nearestValue;
    }
    private int getNearestValue(int a,int b,int target){
        int absA=Math.abs(a-target);
        int absB=Math.abs(b-target);
        return absA>absB? b : a;
    }
    public int methodThree(int[] nums, int target){
        Arrays.sort(nums);
        Integer nearestValue=null;
        int end=nums.length-1;
        for (int i=0;i<nums.length-2;i++){
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j=end;
            int z=i+1;
            while (j>z){


                int total=nums[i]+nums[j]+nums[z];
                if (total>target){
                    j--;
                    while (nums[j]==nums[j+1]&&j>z){
                        j--;
                    }
                }else if (total<target){
                    z++;
                    while (nums[z]==nums[z-1]&&j>z){
                        z++;
                    }
                }else {
                    return total;
                }
                if (nearestValue==null){
                    nearestValue=total;
                }else {
                    nearestValue=Math.abs(nearestValue-target)>Math.abs(total-target)? total:nearestValue;
                }

            }
        }
        return nearestValue;
    }
    public static void main(String[] args) {

        int[] nums=new int[]{-1,2,1,-4};
        Sixteen sixteen=new Sixteen();
        int i = sixteen.methodThree(nums, 1);

        System.out.println(i);
    }
}
