package page.leetcode.thirtySeven;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 *
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 *
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 *
 * 注意：Tony 可以按任意顺序购买雪糕。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneThousandEightHundredAndThirtyThree {

    public int maxIceCream(int[] costs, int coins) {
        int count=0;
        Arrays.sort(costs);
        for(int cost:costs){
            coins-=cost;
            if (coins>=0){
                count++;
            }else {
                break;
            }
        }
        return count;
    }
    public static int methodTwo(int[] costs, int coins){

        int max=0;
        for (int cost:costs){
            max= Math.max(max, cost);
        }
        int[] array=new int[max+1];
        for (int cost:costs){
            array[cost]++;
        }
        int total=0;
        for (int i=1;i<=max;i++){
            if (coins<i){
                break;
            }
            if (array[i]!=0){
                int c=coins/i;
                if (c>array[i]){
                    total+=array[i];
                    coins-=array[i]*i;
                }else {
                    total+=c;
                    coins-=c*i;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,6,3,1,2,5};
        int i = methodTwo(array, 20);
        System.out.println(i);
    }
}
