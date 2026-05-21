class Solution {

    int count = 0;

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> antiDiag = new HashSet<>();

    public int totalNQueens(int n) {

        backtrack(0, n);

        return count;
    }

    private void backtrack(int row, int n) {

        // valid arrangement found
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            int d = row - col;
            int ad = row + col;

            // unsafe position
            if (cols.contains(col)
                    || diag.contains(d)
                    || antiDiag.contains(ad)) {
                continue;
            }

            // place queen
            cols.add(col);
            diag.add(d);
            antiDiag.add(ad);

            backtrack(row + 1, n);

            // remove queen (backtrack)
            cols.remove(col);
            diag.remove(d);
            antiDiag.remove(ad);
        }
    }
}