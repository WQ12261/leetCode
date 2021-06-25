package page.leetcode.two;

/**
 * 63. 不同路径 II
 */
public class SixtyThree {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1){
            return 0;
        }
        int[] array=new int[length];
        for (int i=0;i<obstacleGrid.length;i++){
            for (int j=0;j<length;j++){
                if (i==0&&j==0){
                    array[0]=1;
                }else {
                    if (obstacleGrid[i][j]==1){
                        array[j]=0;
                    }else if (j>0){
                        array[j]+=array[j-1];
                    }
                }
            }
        }
        return array[length-1];
    }
}
