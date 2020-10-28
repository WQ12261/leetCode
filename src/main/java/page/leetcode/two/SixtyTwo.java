package page.leetcode.two;

/**
 * @author 1226134406@qq.com
 * @className SixtyTwo
 * @description 62题
 * @time 2020/10/28 16:11
 */
public class SixtyTwo {
    /**
     *@description: uniquePaths方法是
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *@param: [m, n]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/28 16:11
     */
    public int uniquePaths(int m, int n) {
        int[][]array=new int[m][n];
        for (int i=0;i<n;i++){
            array[0][i]=1;
        }
        for (int i=1;i<m;i++){
            array[i][0]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                array[i][j]=array[i-1][j]+array[i][j-1];
            }
        }
        return array[m-1][n-1];
    }
}
