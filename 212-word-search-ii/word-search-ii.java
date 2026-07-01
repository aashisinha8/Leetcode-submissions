class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // Stores complete word if this node is the end
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Step 1: Build Trie
        for (String word : words) {
            insert(word);
        }

        // Step 2: Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.word = word;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {

        // Boundary check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char ch = board[i][j];

        // Already visited
        if (ch == '#')
            return;

        // Prefix doesn't exist in Trie
        if (node.children[ch - 'a'] == null)
            return;

        // Move to next Trie node
        node = node.children[ch - 'a'];

        // Found a complete word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicates
        }

        // Mark visited
        board[i][j] = '#';

        // Explore all 4 directions
        dfs(board, i + 1, j, node);
        dfs(board, i - 1, j, node);
        dfs(board, i, j + 1, node);
        dfs(board, i, j - 1, node);

        // Restore original character
        board[i][j] = ch;
    }
}