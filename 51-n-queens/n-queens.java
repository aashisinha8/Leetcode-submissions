class Solution {
     List<List<String>> result = new ArrayList<>();

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> antiDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, board, n);

        return result;  
    }
    private void backtrack(int row, char[][] board, int n) {

        if (row == n) {
            result.add(construct(board));
            return;
        }
         for (int col = 0; col < n; col++) {

            int d = row - col;
            int ad = row + col;

            if (cols.contains(col)
                    || diag.contains(d)
                    || antiDiag.contains(ad)) {
                continue;
            }

            // place queen
            board[row][col] = 'Q';

            cols.add(col);
            diag.add(d);
            antiDiag.add(ad);

            backtrack(row + 1, board, n);

         // remove queen (backtrack)
            board[row][col] = '.';

            cols.remove(col);
            diag.remove(d);
            antiDiag.remove(ad);
        }
}
private List<String> construct(char[][] board) {

        List<String> temp = new ArrayList<>();

        for (char[] row : board) {
            temp.add(new String(row));
        }

        return temp;
    }
}