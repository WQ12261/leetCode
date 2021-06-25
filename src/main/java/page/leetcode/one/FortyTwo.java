package page.leetcode.one;

import java.util.Stack;

/**
 * 42题：接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 */
public class FortyTwo {
    public int trap(int[] height) {
        int water=0;
        if (height==null||height.length<=1){
            return water;
        }
        int rightHeight=0;
        for (int i=0;i<height.length-1;i++){
            if (height[i]==0){
                continue;
            }
            int i1 = higherIndex(i, height);
            if (i1-i>1){
                water+=(i1-i-1)*Math.min(height[i],height[i1]);
                for (int j=i+1;j<i1;j++){
                    water-=height[j];
                }
                i=i1-1;
            }
            if (i1==height.length-1){
                rightHeight=i1;
                break;
            }
            if (i1==-1){
                rightHeight=i;
                break;
            }
        }
        if (rightHeight==height.length-1){
            return water;
        }
        for (int i=height.length-1;i>rightHeight;i--){
            if (height[i]==0){
                continue;
            }
            int i1 = higherIndex(i, rightHeight, height);
            if (i-i1>1){
                water+=(i-i1-1)*Math.min(height[i],height[i1]);
                for (int j=i-1;j>i1;j--){
                    water-=height[j];
                }
                i=i1+1;
            }
            if (i1==rightHeight){
                break;
            }
        }

        return water;
    }
    public int higherIndex(int i,int[] height){
        for (int index=i+1;index<height.length;index++){
            if (height[index]>=height[i]){
                return index;
            }
        }
        return -1;
    }
    public int higherIndex(int i,int highest,int[] height){
        for (int index=i-1;index>highest;index--){
            if (height[index]>=height[i]){
                return index;
            }
        }
        return highest;
    }
    public static int methodTwo(int[] height){
        Stack<Integer> stack=new Stack<>();
        int water=0;

        for (int i=0;i<height.length;i++){
            while (!stack.isEmpty()&&height[stack.peek()]<=height[i]){
                Integer top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                Integer peek = stack.peek();
                int weight=i-peek-1;
                int h=Math.min(height[i],height[peek])-height[top];
                water+=weight*h;
            }
            stack.push(i);
        }
        return water;
    }
    public static int methodThree(int[] height){
        return 0;
    }

    public static void main(String[] args) {
        int[] height={4,2,0,3,2,5};
        int i = methodTwo(height);
        System.out.println(i);
    }
}
