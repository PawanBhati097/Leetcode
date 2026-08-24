class Solution {
    public void solveSudoku(char[][] board) {
        // Convert char board to int board
        int[][] gird = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    gird[i][j] = board[i][j] - '0';
                }
            }
        }
        
        Print(gird, 0, 0);
        
        // Convert back to char board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = (char)(gird[i][j] + '0');
            }
        }
    }
    
    public static boolean Print(int[][] gird, int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }
        if (row == 9) {
            return true;
        }
        if (gird[row][col] != 0) {
            return Print(gird, row, col + 1);
        } else {
            for (int val = 1; val <= 9; val++) {
                if (Is_safe(gird, row, col, val)) {
                    gird[row][col] = val;
                    boolean ans = Print(gird, row, col + 1);
                    if (ans) {
                        return true;
                    }
                    gird[row][col] = 0;
                }
            }
        }
        return false;
    }
    
    public static boolean Is_safe(int[][] gird, int row, int col, int val) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (gird[row][i] == val) {
                return false;
            }
        }
        // Check column
        for (int i = 0; i < 9; i++) {
            if (gird[i][col] == val) {
                return false;
            }
        }
        // Check 3*3 matrix
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (gird[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}