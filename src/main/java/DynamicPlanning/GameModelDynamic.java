package DynamicPlanning;

/**
 * 博弈性动态规划
 */
public class GameModelDynamic {
    /**
     * 题意：有一排N个石子，Alice，Bob两人轮流取石子，
     * 每次一个人可以从最右边取走一个或两个石子，取走最后石子的人胜，
     * 问先手Alice是否必胜(先手必胜:true，先手必败：false)
     */
    public static boolean firstWillWin(int count) {
        if (count == 0) {
            return false;
        }
        if (count == 1 || count == 2) {
            return true;
        }
        boolean[] winFlag = new boolean[count + 1];
        winFlag[1] = winFlag[2] = true;
        for (int i = 3; i <= count; i++) {
            if ((!winFlag[i -1]) || (!winFlag[i - 2])){
                winFlag[i] = true;
            }
        }
        return winFlag[count];
    }

    public static void main(String[] args) {
        System.out.println(firstWillWin(10));
    }
}
