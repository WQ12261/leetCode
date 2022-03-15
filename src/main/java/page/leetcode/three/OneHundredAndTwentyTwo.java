package page.leetcode.three;

public class OneHundredAndTwentyTwo {

    public static int maxProfit(int[] prices) {
        int profit=0;
        int buyIndex=0;
        int lastIndex=prices.length-1;
        for (int i=1;i<lastIndex;i++){
            if (prices[i]>prices[buyIndex]){
                if (prices[i+1]<prices[i]){
                    profit+=prices[i]-prices[buyIndex];
                    buyIndex=i+1;
                }
                i++;
            }else {
                buyIndex=i;

            }
        }
        if (buyIndex<lastIndex&&prices[lastIndex]>prices[buyIndex]){
            profit+=prices[lastIndex]-prices[buyIndex];
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] numbers=new int[]{1,2,3,4,5};
        int i = maxProfit(numbers);
        System.out.println(i);
    }

}
