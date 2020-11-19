package page.leetcode.nine;

import array.util.ArrayUtil;

/**
 * @author 1226134406@qq.com
 * @className FourHundredAndSix
 * @description 406题
 * @time 2020/11/16 21:00
 */
public class FourHundredAndSix {
    /**
     * @description: reconstructQueue方法是
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
     * 注意：
     * 总人数少于1100人。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
     * 示例
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     * @param: [people]
     * @retrun: int[][]
     * @auther: 1226134406@qq.com
     * @date: 2020/11/16 21:04
     */
    public int[][] reconstructQueue(int[][] people) {
        return null;
    }

    public int[] getStep(int[][] people) {
        int[] step = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int height = people[i][0];//第i个人的身高
            int peek = 0;//第i个人前面有多少人比它高
            for (int j = 0; j < i; j++) {
                if (people[j][0]>=people[i][0]){
                    peek++;
                }
            }
            step[i]=peek-people[i][1];
        }
        return step;
    }
    private void move(int[][] people,int[] step){

    }

    public static void main(String[] args) {
        FourHundredAndSix fourHundredAndSix=new FourHundredAndSix();
        int[][] people=new int[6][];
        people[0]= new int[]{7, 0};
        people[1]= new int[]{4, 4};
        people[2]= new int[]{7, 1};
        people[3]= new int[]{5, 0};
        people[4]= new int[]{6, 1};
        people[5]= new int[]{5, 2};
        int[] step = fourHundredAndSix.getStep(people);
        ArrayUtil.showOnwDimension(step);

    }

}
