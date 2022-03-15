package page.leetcode.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndTwenty {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> list=new ArrayList<>();
        list.add(triangle.get(0).get(0));
        int minValue=Integer.MAX_VALUE;
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        for (int i=1;i<triangle.size();i++){
            List<Integer> lineList=triangle.get(i);
            int preValue=list.get(0);
            for (int j=0;j<lineList.size();j++){

                int right=lineList.get(j)+preValue;
                int upper=right;
                if (j<list.size()){
                    upper=lineList.get(j)+list.get(j);

                }
                int min=Math.min(upper, right);

                if (i==triangle.size()-1){
                    minValue=Math.min(min, minValue);
                }else {
                    if (j==list.size()){
                        list.add(min);
                    }else {
                        list.set(j, min);
                    }
                }
            }
        }
        return minValue;
    }
}
