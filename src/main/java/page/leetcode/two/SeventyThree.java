package page.leetcode.two;

import array.util.TowDimension;

/**
 * 73题 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SeventyThree {
    public static void setZeroes(int[][] matrix) {
        boolean col=false;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    if (j==0){
                        col=true;
                    }else {
                        matrix[0][j]=0;
                    }
                }
            }
        }
        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[i].length;j++){
                if (matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if (matrix[0][0]==0){
            for (int i=1;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        if (col==true){
            for (int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix=new int[1][3];
        matrix[0]=new int[]{1,0,2,3};
        setZeroes(matrix);
        TowDimension.showTowDimension(matrix);
    }

}
