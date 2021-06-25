package page.leetcode.three;

/**
 * 134. 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明: 
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndThirtyFour {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        final int len=gas.length;
        int[] totalSurplus=new int[len];
        int[] surplus=new int[len];
        int total=0;

        int firstIndex=-1;
        for (int i=0;i<len;i++){
            int sur=gas[i]-cost[i];
            surplus[i]=sur;
            if (firstIndex==-1&&sur>=0){
                firstIndex=i;
            }
            total+=sur;
            totalSurplus[i]=total;
        }
        if (total<0){
            return -1;
        }
        for (int i=firstIndex;i<len;i++){
            int j=i+1;
            int nextSurplus=surplus[i];
            if (nextSurplus<0){
                continue;
            }else if (i==len-1){
                return i;
            }
            for (;j<len;j++){
                nextSurplus+=surplus[j];
                if (nextSurplus<0){
                    i=j;
                    break;
                }else if (j==len-1){
                    return i;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas={2};
        int[] cost={2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
