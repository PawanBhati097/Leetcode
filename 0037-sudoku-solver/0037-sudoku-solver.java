class Solution {
    public void solveSudoku(char[][] board) {
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = board[i][j] - '0';
                }
            }
        }
        solve(grid, 0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = (char)(grid[i][j] + '0');
            }
        }
    }
    
    public boolean solve(int[][] grid, int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }
        if (row == 9) {
            return true;
        }
        if (grid[row][col] != 0) {
            return solve(grid, row, col + 1);
        } else {
            for (int val = 1; val <= 9; val++) {
                if (isSafe(grid, row, col, val)) {
                    grid[row][col] = val;
                    if (solve(grid, row, col + 1)) {
                        return true;
                    }
                    grid[row][col] = 0;
                }
            }
        }
        return false;
    }
    
    public boolean isSafe(int[][] grid, int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == val) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == val) {
                return false;
            }
        }
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (grid[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}