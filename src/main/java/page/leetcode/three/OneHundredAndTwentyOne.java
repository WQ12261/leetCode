package page.leetcode.three;

/**
 *@className OneHundredAndTwentyOne
 *@description 121题
 *@author 1226134406@qq.com
 *@time 2020/10/26 14:25
 *@version
 */
public class OneHundredAndTwentyOne {
    /**
     *@description: maxProfit方法是
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * 注意：你不能在买入股票前卖出股票。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *@param: [prices]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/26 14:26
     */
    public static int maxProfit(int[] prices) {
        int max=0;
        if (prices==null||prices.length<=1){
            return max;
        }
        int low=prices[0];
        for(int i=0;i<prices.length;i++){
            if (prices[i]<low){
                low=prices[i];
            }else {
                int profit=prices[i]-low;
                max=profit>max? profit:max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices={7,6,4,3,1};
        int i = maxProfit(prices);
        System.out.println(i);
    }
}
