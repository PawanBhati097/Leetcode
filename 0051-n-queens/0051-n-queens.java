class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        print(board, 0, result);
        return result;
    }
    
    public void print(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                print(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }
    
    public boolean isSafe(char[][] board, int row, int col) {
        int r = row;
        while (r >= 0) {
            if (board[r][col] == 'Q') {
                return false;
            }
            r--;
        }
        r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c = col;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    
    public List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }
}