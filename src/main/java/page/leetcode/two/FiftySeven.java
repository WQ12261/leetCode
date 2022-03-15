package page.leetcode.two;

import array.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FiftySeven {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals==null||intervals.length==0||intervals[0].length==0){
            int[][] interval=new int[1][];
            interval[0]=newInterval;
            return interval;
        }
        List<int[]> list=new ArrayList<>();
        int i=0;
        boolean flag=true;
        int[] interval=null;
        for (;i<intervals.length;i++){
            if (flag){
                if (intervals[i][0]>newInterval[1]){
                    list.add(newInterval);
                    break;
                }
                if (intervals[i][1]<newInterval[0]){
                    list.add(intervals[i]);
                    continue;
                }
                if (intervals[i][0]<=newInterval[1]&&intervals[i][1]>=newInterval[1]){
                    intervals[i][0]=Math.min(intervals[i][0],newInterval[0]);
                    return intervals;
                }
                if (intervals[i][1]<newInterval[1]){
                    intervals[i][0]=Math.min(intervals[i][0],newInterval[0]);
                    intervals[i][1]=newInterval[1];
                    interval=intervals[i];
                    list.add(interval);
                    flag=false;
                }
            }else {
                if (intervals[i][0]>interval[1]){
                    break;
                }
                if (intervals[i][1]>=interval[1]){
                    interval[1]=intervals[i][1];
                    i++;
                    break;
                }
            }
        }
        if (list.size()>0){
            interval=list.get(list.size()-1);
            if (interval[1]<newInterval[1]){
                list.add(newInterval);
            }
        }
        int length=list.size()+intervals.length-i;
        int[][] intervalArray=new int[length][];
        int i1 = 0;
        for (;i1<list.size();i1++){
            intervalArray[i1]=list.get(i1);
        }
        for (;i<intervals.length;i++,i1++){
            intervalArray[i1]=intervals[i];
        }
        return intervalArray;
    }

    public static void main(String[] args) {
        int[][] intervals=new int[5][];
        intervals[0]=new int[]{1,2};
        intervals[1]=new int[]{4,5};
        intervals[2]=new int[]{6,7};
        intervals[3]=new int[]{8,10};
        intervals[4]=new int[]{12,16};
        int[] newIntervals={-1,0};
        int[][] insert = insert(intervals, newIntervals);
        ArrayUtil.showTowDimension(insert);
    }
}
