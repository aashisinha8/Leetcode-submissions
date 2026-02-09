class Solution {
    public int maxArea(int[] height) {
        int max_area=0;
      int l=0;
      int r=height.length-1;
       while(l<r){
        int low=height[l];
        int high=height[r];
         int length=r-l;
        int min_height=Math.min(low,high);
        max_area=Math.max(max_area,length*min_height);
        if(low<high){
            l++;
        }
        else{
            r--;
        }

       } 
       return max_area;
    }
}