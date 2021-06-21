package page.leetcode.two;

import array.util.TowDimension;

/**
 * 59题
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class FiftyNine {
    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int count=1;
        int direction=0;//0:向右，1：向下，2：向左，3：向上
        int row=0;
        int column=0;
        int circle=0;//圈数
        while(row+circle<n&&column+circle<n){
            array[row][column]=count++;
            if (direction==0){
                column++;
                if (column==n-1-circle){
                    direction=1;
                }
            }else if (direction==1){
                row++;
                if (row==n-1-circle){
                    direction=2;
                }
            }else if (direction==2){
                column--;
                if (column==0+circle){
                    direction=3;
                }
            }else{
                if (row==0+circle+1){
                    direction=0;
                    circle++;
                    column++;
                }else {
                    row--;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        FiftyNine fiftyNine=new FiftyNine();
        int[][] array = fiftyNine.generateMatrix(4);
        TowDimension.showTowDimension(array);
    }
}
