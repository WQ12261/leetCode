package page.leetcode.two;

import array.util.ArrayUtil;

/**
 *@className SixtyFour
 *@description 64题
 *@author 1226134406@qq.com
 *@time 2020/10/27 11:28
 *@version
 */
public class SixtyFour {
    /**
     *@description: minPathSum方法是
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *@param: [grid]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/27 11:28
     */
    public static int minPathSum(int[][] grid) {
        final int col=grid[0].length;
        final int row=grid.length;
        int[][] arrays=new int[row][col];
        arrays[0][0]=grid[0][0];

        for (int i=1;i<row;i++){
            arrays[i][0]=grid[i][0]+arrays[i-1][0];
        }
        for (int j=1;j<col;j++){
            arrays[0][j]=grid[0][j]+arrays[0][j-1];
        }

        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                int min=arrays[i-1][j]<arrays[i][j-1]? arrays[i-1][j]:arrays[i][j-1];
                arrays[i][j]=grid[i][j]+min;
            }
        }
        ArrayUtil.showTowDimension(arrays);
        return arrays[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] ints = ArrayUtil.generatorTwoDimension(4, 4, 5, false);
        ArrayUtil.showTowDimension(ints);
        System.out.println("================================");
        minPathSum(ints);
    }
}
