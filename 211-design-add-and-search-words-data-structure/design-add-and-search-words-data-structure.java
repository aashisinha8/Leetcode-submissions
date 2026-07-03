class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isWord = false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode curr = root;

        for(char ch : word.toCharArray()){

            int idx = ch-'a';

            if(curr.child[idx]==null)
                curr.child[idx]=new TrieNode();

            curr=curr.child[idx];
        }

        curr.isWord=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word,int i,TrieNode node){

        if(node==null)
            return false;

        if(i==word.length())
            return node.isWord;

        char ch=word.charAt(i);

        if(ch!='.'){
            return dfs(word,i+1,node.child[ch-'a']);
        }

        for(int k=0;k<26;k++){

            if(node.child[k]!=null){

                if(dfs(word,i+1,node.child[k]))
                    return true;
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */