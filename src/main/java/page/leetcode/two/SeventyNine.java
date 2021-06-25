package page.leetcode.two;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SeventyNine {
    public static boolean exist(char[][] board, String word) {
        if (word==null||"".equals(word)){
            return false;
        }
        char[] chars = word.toCharArray();
        byte[][] flagBoard=new byte[board.length][board[0].length];

        byte count=0;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==chars[0]){
                    count++;
                    if (searchExist(chars, i, j,0, count,board,flagBoard)){
                        return true ;
                    }
                }
            }
        }
        return false;
    }

    public static boolean searchExist(char[] charArray,int i,int j,int startIndex,byte count,char[][] board,byte[][] flagBoard) {

        if (board[i][j] != charArray[startIndex]) {
            return false;
        }
        if (startIndex == charArray.length - 1) {
            return true;
        }
        flagBoard[i][j] = count;
        int right = j + 1;
        int left = j - 1;
        int upper = i - 1;
        int below = i + 1;
        startIndex++;
        if (right < board[0].length && flagBoard[i][right] != count && searchExist(charArray, i, right, startIndex , count, board, flagBoard)) {
            return true;
        } else if (below < board.length && flagBoard[below][j] != count && searchExist(charArray, below, j, startIndex, count, board, flagBoard)) {
            return true;
        } else if (left >= 0 && flagBoard[i][left] != count && searchExist(charArray, i, left, startIndex, count, board, flagBoard)) {
            return true;
        } else if (upper >= 0 && flagBoard[upper][j] != count && searchExist(charArray, upper, j, startIndex, count, board, flagBoard)) {
            return true;
        } else {
            flagBoard[i][j]=0;
            return false;
        }
    }
    public static void main(String[] args) {
        char[][] board=new char[3][4];
        board[0]=new char[]{'A','B','C','E'};
        board[1]=new char[]{'S','F','E','S'};
        board[2]=new char[]{'A','D','E','E'};
        String string="ABCEFSADEESE";
        System.out.println(exist(board, string));

    }
}
