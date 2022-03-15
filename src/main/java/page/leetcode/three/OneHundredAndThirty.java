package page.leetcode.three;

import java.util.HashMap;
import java.util.Map;

public class OneHundredAndThirty {
    public void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int m = board.length -1;
        int n = board[0].length -1;
        for (int i = 0; i <= n; i++) {
            mark(0, i, board);
            mark(m, i, board);
        }
        for (int i = 0;i<m;i++){
            mark(i, 0, board);
            mark(i, n, board);
        }
        for (int i= 0;i<=m;i++){
            for (int j =0;j<=n ;j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }

            }
        }
    }

    private void mark(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        mark(i - 1, j, board);
        mark(i + 1, j, board);
        mark(i, j + 1, board);
        mark(i, j - 1, board);
    }


    //[['O','O','O','O','X','X'],
    //['O','O','O','O','O','O'],
    //['O','X','O','X','O','O'],
    //['O','X','O','O','X','O'],
    //['O','X','O','X','O','O'],
    //['O','X','O','O','O','O']]
    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X'},
                {'X','O','O'},
                {'X','X','O'},
                {'X','O','X'},
                };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("\t" + board[i][j]);
            }
            System.out.println();
        }
        Map<String,String> map = new HashMap<>();
        map.put("a", "b");
        
        OneHundredAndThirty oneHundredAndThirty = new OneHundredAndThirty();
        oneHundredAndThirty.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("\t" + board[i][j]);
            }
            System.out.println();
        }
    }

}
