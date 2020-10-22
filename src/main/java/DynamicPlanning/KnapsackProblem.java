package DynamicPlanning;

import java.util.Arrays;

/**
 *@className KnapsackProblem
 *@description 动态规划之背包问题
 *@author 1226134406@qq.com
 *@time 2020/10/18 21:37
 *@version
 */
public class KnapsackProblem {
    /**
     *@description:
     * 有一个背包,可称重量为4磅，现有物品如下：
     *  物品       重量            价值
     *  吉他       1              1500
     *  音响       4              3000
     *  电脑       3              2000
     *  1.要求达到的目标为装入背包的总价值最大，并且重量不能超出背包的载荷
     *  2.要求装入的物品不能重复
     */
    private int  getMaxValue(){
        int[][] arr=new int[4][5];
        for (int j=0;j<5;j++){
            arr[0][j]=0;
        }
        for (int i=0;i<4;i++){
            arr[i][0]=0;
        }
        int[] value={0,1500,3000,2000};
        int[] weight={0,1,4,3};
        int sum=0;
        for (int i=1;i<4;i++){
            for (int j=1;j<5;j++){
                if (j<weight[i]){
                    arr[i][j]= arr[i-1][j];
                }else {
                    int c=value[i]+arr[i-1][j-weight[i]];
                    arr[i][j]=Math.max(sum, c);
                }
            }
        }
        for (int i=0;i<4;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        return arr[3][4];
    }
    /**
     *@description: salveZeroOne方法是 01背包问题
     *@param: [weight：各个物品的重量, val：各个物品的价值, capacity：背包的载荷]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/19 9:17
     */
    public int salveZeroOne(int[]weight,int[]val,int capacity){
        if (weight.length!=val.length){
            return 0;
        }
        int[][] arr=new int[val.length+1][capacity+1];
        //将第0列复制为0
        for(int i=0;i<arr.length;i++){
            arr[i][0]=0;
        }
        //将第0行赋值为0
        for (int j=0;j<arr[0].length;j++){
            arr[0][j]=0;
        }
        for (int i=1;i<arr.length;i++){
            for (int j=1;j<arr[0].length;j++){
                if (j<weight[i-1]){
                     arr[i][j]=arr[i-1][j];
                }else {
                    int v=val[i-1]+arr[i-1][j-weight[i-1]];
                    arr[i][j]=Math.max(v, arr[i-1][j]);
                }
            }
        }
        /*for (int [] array:arr){
            System.out.println(Arrays.toString(array));
        }*/
        return arr[val.length][capacity];
    }

    public static void main(String[] args) {
        KnapsackProblem knapsackProblem=new KnapsackProblem();
        int[] value={1500,3000,2000};
        int[] weight={1,4,3};
        int i = knapsackProblem.salveZeroOne(weight, value, 7);
        System.out.println(i);
    }
}
