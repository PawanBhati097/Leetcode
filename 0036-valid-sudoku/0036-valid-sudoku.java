class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int val = board[r][c] - '1'; // Map '1'-'9' to index 0-8
                    int boxIdx = (r / 3) * 3 + (c / 3);

                    if (rows[r][val] || cols[c][val] || boxes[boxIdx][val]) {
                        return false;
                    }

                    rows[r][val] = true;
                    cols[c][val] = true;
                    boxes[boxIdx][val] = true;
                }
            }
        }
        return true;
    }
}