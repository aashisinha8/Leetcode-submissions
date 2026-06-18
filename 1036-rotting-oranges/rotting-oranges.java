class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> list=new LinkedList<>();
        int fresh=0;
         // Put all rotten oranges in queue
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    list.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;//storeth =e count fresh to checklater
                }
            }
         }
          if (fresh == 0) {
            return 0;
        }
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
/*Row - 1 => Up
Row + 1 => Down
Col - 1 => Left
Col + 1 => Right*/
int minutes=0;
while(!list.isEmpty()){
    int size=list.size();
    boolean rotten=false;
     for (int k = 0; k < size; k++) {

                int[] curr = list.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    
                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                        fresh--;
                        list.offer(new int[]{nr, nc});
                        rotten = true;
                        }
                }
}
 if (rotten) {
                minutes++;
            }
}
            return fresh==0?minutes:-1;
    }
}
