package page.leetcode.four;

/**
 *@className OneHundredAndNinetyEight
 *@description 198题
 *@author 1226134406@qq.com
 *@time 2020/10/27 11:05
 *@version
 */
public class OneHundredAndNinetyEight{
    /**
     *@description: rob方法是
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *@param: [nums]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/27 11:06
     */
    public static int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int pre=nums[0];
        int max=nums[0]>nums[1]? nums[0]:nums[1];
        for (int i=2;i<nums.length;i++){
            int swap=pre+nums[i];
            pre=max;
            max=swap>max? swap:max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
