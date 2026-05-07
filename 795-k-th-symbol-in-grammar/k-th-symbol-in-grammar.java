class Solution {
    public int kthGrammar(int n, int k) {
        // Base row
        if(n==1){
            return 0;
        }
        //consider it as a tree  for like every 0 two chile 01 and 1 as paret with two chils 1 and 0
         // Find parent in previous row
        int parent=kthGrammar(n-1,(k+1)/2);
        // Odd index -> same as parent
        if(k%2==1){
            return parent;
        }
        // Even index -> flipped value
            return 1-parent;
        
    }
}