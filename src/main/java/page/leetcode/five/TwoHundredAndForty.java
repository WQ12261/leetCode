package page.leetcode.five;

import java.util.Arrays;

public class TwoHundredAndForty {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[m].length - 1;
        if (matrix[0][0] > target || matrix[m][n] < target) {
            return false;
        }
        int topM = 0;
        int topN = 0;
        int centerM = (topM + m) / 2;
        int centerN = (topN + n) / 2;
        while (topM <= m && topN <= n) {

            int value = matrix[centerM][centerN];
            if (value == target) {
                return true;
            } else if (value > target) {
                if (topM == m && topN == n) {
                    return false;
                }
                int centerM1 = centerM > topM ? centerM - 1 : centerM;
                int centerN1 = centerN > topN ? centerN - 1 : centerN;

                int value1 = matrix[centerM1][centerN1];
                if (value1 == target) {
                    return true;
                } else if (value1 > target) {
                    m = centerM1;
                    n = centerN1;
                } else {
                    break;
                }
            } else {
                if (topM == m && topN == n) {
                    return false;
                }
                int centerM1 = centerM < m ? centerM + 1 : centerM;
                int centerN1 = centerN < n ? centerN + 1 : centerN;
                int value1 = matrix[centerM1][centerN1];
                if (value1 == target) {
                    return true;
                } else if (value1 < target) {
                    topM = centerM1;
                    topN = centerN1;
                } else {
                    centerM = centerM1;
                    centerN = centerN1;
                    break;
                }
            }
            centerM = (topM + m) / 2;
            centerN = (topN + n) / 2;
        }
        int i = Arrays.binarySearch(matrix[centerM], 0, centerN, target);
        if (i >= 0) {
            return true;
        }
        return binarySearch(matrix, centerN, centerM, target);
    }

    private static boolean binarySearch(int[][] matrix, int col, int endRow, int target) {
        if (matrix[0][col] > target || matrix[endRow][col] < target) {
            return false;
        }

        int startRow = 0;
        while (startRow < endRow) {
            int center = endRow / 2;
            int value = matrix[center][col];
            if (value == target) {
                return true;
            } else if (value < target) {
                startRow = center + 1;
            } else {
                endRow = center - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[2][];
        matrix[0] = new int[]{1, 4};
        matrix[1] = new int[]{2, 5};
        boolean b = searchMatrix(matrix, 2);
        System.out.println(b);
    }

}
