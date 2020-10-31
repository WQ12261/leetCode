package page.leetcode.ten;

/**
 * @author 1226134406@qq.com
 * @className FourHundredAndSixtyFour
 * @description 463题
 * @time 2020/10/30 19:55
 */
public class FourHundredAndSixtyFour {
    //给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
    //网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
    //岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/island-perimeter
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int islandPerimeter(int[][] grid) {
        int count=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid.length;j++){
                if (grid[i][j]==1){
                    count+=4;
                    int a=i-1;
                    int b=i+1;
                    int c=j-1;
                    int d=j+1;
                    if (a>=0&&a<grid.length&&grid[a][j]==1){
                        count--;
                    }
                    if (b<grid.length&&b>=0&&grid[b][j]==1){
                        count--;
                    }
                    if (c>=0&&c<grid[i].length&&grid[i][c]==1){
                        count--;
                    }
                    if (d<grid[i].length&&d>=0&&grid[i][d]==1){
                        count--;
                    }
                }
            }
        }

        return count;
    }
}
