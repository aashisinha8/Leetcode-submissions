class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1) return false;        
        int result=1;
        
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                result+=i;
                if(i!=num/i){
                result+=num/i;
            }
            }
            
        }
         return result==num;
    }
}